package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.GeoIpException;
import tc.lv.utils.GeoIpUtil;

@Repository
public class IpAddressDaoImpl extends DaoAbstract implements IpAddressDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    private static final Logger LOGGER = Logger.getLogger(IpAddressDaoImpl.class);
    private static GeoIpUtil geoIpUtil = null;

    public IpAddressDaoImpl() throws GeoIpException {
        if (geoIpUtil == null)
            geoIpUtil = new GeoIpUtil();
    }

    public IpAddressDaoImpl(EntityManager entityManager) throws GeoIpException {
        this();
        this.entityManager = entityManager;
    }

    @Override
    public Long countAll(Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countAll());
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIp(boolean status, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusList()).setParameter(1,
                status);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIpByCityName(boolean status, String cityName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusIpByCityName());
        query = query.setParameter(1, status).setParameter(2, cityName);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIpByCountryName(boolean status, String countryName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusIpByCountryName());
        query = query.setParameter(1, status).setParameter(2, countryName);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIpByCountryCode(boolean status, String countryCode, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusIpByCountryCode());
        query = query.setParameter(1, status).setParameter(2, countryCode);
        return (Long) query.getSingleResult();
    }

    @Override
    public void deleteIp(IpAddress address) {
        entityManager.remove(address);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> T findByAddress(String address, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findByAddress()).setParameter(1,
                address);
        return (T) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findIpListBySource(int sourceId, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findIpListBySource());
        query.setParameter(1, sourceId);
        return query.getResultList();
    }

    @Override
    public <T extends IpAddress> List<T> findStatusList(boolean status, int from, int count,
            Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findStatusList()).setParameter(1,
                status);
        return findRange(from, count, query);
    }

    @Override
    public <T extends IpAddress> List<T> findStatusListByCity(boolean status, int from, int count,
            String cityName, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findStatusListByCity());
        query = query.setParameter(1, status).setParameter(2, cityName);
        return findRange(from, count, query);
    }

    @Override
    public <T extends IpAddress> List<T> findStatusListByCountryName(boolean status, int from, int count,
            String countryName, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findStatusListByCountryName());
        query = query.setParameter(1, status).setParameter(2, countryName);
        return findRange(from, count, query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findUndefList(Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findUndefinedList());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    private <T extends IpAddress> T createIpAddress(Class<? extends IpAddress> ipType) throws DBException {
        try {
            return (T) ipType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new DBException("New Instantiation Exception", e);
        }
    }

    @Override
    public void removeIpFromStatusList(boolean status, IpAddress address) {
        address.setStatus(status);
        entityManager.persist(address);
    }

    @Override
    public void save(IpAddress address) {
        address.setModified(true);
        entityManager.persist(address);
        IpAddress.IP_MAP.put(address.getAddress(), address);
    }

    @Override
    public IpAddress update(IpAddress address) {
        // address.setModified(true);
        address = entityManager.merge(address);
        IpAddress.IP_MAP.put(address.getAddress(), address);
        return address;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void creatIpMap() {
        if (!IpAddress.IS_MAP_CREATE) {
            Query query = entityManager.createNamedQuery(IpAddress.FIND_ALL_VALID);
            List<IpAddress> listFromDB = query.getResultList();
            for (IpAddress ip : listFromDB) {
                ip.setModified(false);
                IpAddress.IP_MAP.put(ip.getAddress(), ip);
            }
            IpAddress.IS_MAP_CREATE = true;
        }
    }

    @Override
    public boolean addSource(IpAddress ip, Source source) {
        if (source.getSourceName().equals(Source.ADMIN_BLACK_LIST)) {
            Source removeSource = (Source) entityManager.createNamedQuery(Source.FIND_BY_NAME)
                    .setParameter(1, Source.ADMIN_WHITE_LIST).getSingleResult();
            ip.removeSource(removeSource);
        } else if (source.getSourceName().equals(Source.ADMIN_WHITE_LIST)) {
            Source removeSource = (Source) entityManager.createNamedQuery(Source.FIND_BY_NAME)
                    .setParameter(1, Source.ADMIN_BLACK_LIST).getSingleResult();
            ip.removeSource(removeSource);
        }
        return ip.addSource(source);
    }
}
