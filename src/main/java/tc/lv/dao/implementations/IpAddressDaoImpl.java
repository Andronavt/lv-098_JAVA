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
import tc.lv.domain.City;
import tc.lv.domain.Country;
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
    public Integer countAll(Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countAll());
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countStatusIp(boolean status, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusList()).setParameter(1,
                status);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countStatusIpByCityName(boolean status, String cityName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusIpByCity());
        query = query.setParameter(1, status).setParameter(2, cityName);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countStatusIpByCountryName(boolean status, String countryName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).countStatusIpByCountry());
        query = query.setParameter(1, status).setParameter(2, countryName);
        return (Integer) query.getSingleResult();
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
    public List<City> findCityListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findCityListByStatus());
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Country> findCountryListByStatus(boolean status, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findCountryListByStatus());
        query = query.setParameter(1, status);
        return query.getResultList();
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
    public <T extends IpAddress> List<T> findStatusListByCountry(boolean status, int from, int count,
            String countryName, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findStatusListByCountry());
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
            // We can't find source for this Id
            // TODO
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
            if (set == null) {
                continue;
            }

            Iterator<Source> it = set.iterator();
            double blackRank = 0;
            double whiteRank = 0;
            while (it.hasNext()) {
                Source source = it.next();
                if (source.getListType().equals(Source.WHITE_LIST)) {
                    whiteRank += source.getRank();
                } else if (source.getListType().equals(Source.BLACK_LIST)) {
                    blackRank += source.getRank();
                } else {
                    throw new DBException(source.getListType() + " didn't supported by updateStatusList() method");
                }
            }

            if (whiteRank > blackRank) {
                ip.setStatus(true);
            } else {
                ip.setStatus(false);
            }
            entityManager.persist(ip);
        }
    }

    @Override
    public String findCountryCodeByCountryName(String country, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(createIpAddress(ipType).findCountryCodeByCountryName());
        query = query.setParameter(1, country);
        return (String) query.getSingleResult();
    }
}
