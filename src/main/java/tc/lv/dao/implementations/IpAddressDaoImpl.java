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
        Query query = entityManager.createNamedQuery(newInstance(ipType).countAll());
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIp(boolean status, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).countStatusList())
                .setParameter(1, status);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIpByCityName(boolean status, String cityName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).countStatusIpByCity());
        query = query.setParameter(1, status).setParameter(2, cityName);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countStatusIpByCountryName(boolean status, String contryName, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).countStatusIpByCountry());
        query = query.setParameter(1, status).setParameter(2, contryName);
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
        Query query = entityManager.createNamedQuery(newInstance(ipType).findByAddress()).setParameter(1, address);
        return (T) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCityListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findCityListByStatus());
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountryListByStatus(boolean status, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findCountryListByStatus());
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findIpListBySource(int sourceId, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findIpListBySource());
        query.setParameter(1, sourceId);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findStatusList(boolean status, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findStatusList()).setParameter(1, status);
        return query.getResultList();
    }

    @Override
    public <T extends IpAddress> List<T> findStatusListByCity(boolean status, int from, int count,
            String cityName, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findStatusListByCity());
        query = query.setParameter(1, status).setParameter(2, cityName);
        return findRange(from, count, query);
    }

    @Override
    public <T extends IpAddress> List<T> findStatusListByCountry(boolean status, int from, int count,
            String contryName, Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findStatusListByCountry());
        query = query.setParameter(1, status).setParameter(2, contryName);
        return findRange(from, count, query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findUndefList(Class<? extends IpAddress> ipType) throws DBException {
        Query query = entityManager.createNamedQuery(newInstance(ipType).findUndefinedList());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    private <T extends IpAddress> T newInstance(Class<? extends IpAddress> ipType) throws DBException {
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

            Query query = entityManager.createNamedQuery(newInstance(ipType).findAll());
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

        Query query = entityManager.createNamedQuery(newInstance(ipType).findAll());
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
                    // Maybe throw new
                    // MyException("Something wrong... Can't find whitelist neither blacklist mark")
                    // TODO
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
}
