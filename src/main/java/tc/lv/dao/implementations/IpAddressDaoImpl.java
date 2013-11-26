package tc.lv.dao.implementations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBException;

@Repository
public class IpAddressDaoImpl extends DaoAbstract implements IpAddressDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public IpAddressDaoImpl() {

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
        entityManager.persist(address);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void saveList(List<? extends IpAddress> list, int sourceId, Class<? extends IpAddress> ipType)
            throws DBException {

        Source source = entityManager.find(Source.class, sourceId);
        if (source == null) {
            throw new DBException("Didn't find source with id " + sourceId);
        } else {
            if (list.size() < 1) {
                return;
            }

            Query query = entityManager.createNamedQuery(createIpAddress(ipType).findAll());
            Map<String, IpAddress> map = new HashMap<String, IpAddress>();

            List<IpAddress> listFromDB = query.getResultList();
            for (IpAddress ip : listFromDB) {
                map.put(ip.getAddress(), ip);
            }

            for (IpAddress ip : list) {
                if (!map.containsKey(ip.getAddress())) {

                    entityManager.persist(ip);
                    map.put(ip.getAddress(), ip);
                } else {

                    IpAddress temp = map.get(ip.getAddress());
                    temp.getSourceSet().add(source);
                    entityManager.persist(temp);
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void updateStatusList(Class<? extends IpAddress> ipType) throws DBException {
        if (ipType.equals(NotValidIp.class)) {
            return;
        }

        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findAll());
        List<? extends IpAddress> list = query.getResultList();

        for (IpAddress ip : list) {
            Set<Source> set = ip.getSourceSet();
            if (set == null || set.size() == 0) {
                continue;
            }
            ip = rankLogick(set, ip);
            entityManager.persist(ip);
        }
    }

    private IpAddress rankLogick(Set<Source> set, IpAddress ip) throws DBException {
        Iterator<Source> it = set.iterator();
        double statuskRank = 0;
        while (it.hasNext()) {
            Source source = it.next();
            if (source.getListType().equals(Source.WHITE_LIST)) {
                statuskRank += source.getRank();
            } else if (source.getListType().equals(Source.BLACK_LIST)) {
                statuskRank -= source.getRank();
            } else {
                throw new DBException(source.getListType() + " didn't supported by updateStatusList() method");
            }
        }

        ip.setStatus(statuskRank > 0);
        return ip;
    }
}
