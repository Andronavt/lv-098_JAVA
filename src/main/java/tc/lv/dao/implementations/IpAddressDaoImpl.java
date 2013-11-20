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
import tc.lv.domain.Source;

@Repository
public class IpAddressDaoImpl extends DaoAbstract implements IpAddressDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public IpAddressDaoImpl() {

    }

    @Override
    public Integer countAll(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.countAll());
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countBlackIp(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.countWhiteOrBlackList()).setParameter(1, false);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countBlackListByCountyName(String contryName, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.countWhiteOrBlackList());
        query = query.setParameter(1, false).setParameter(2, contryName);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countWhiteIp(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.countWhiteOrBlackList()).setParameter(1, true);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer countWhiteListByCountyName(String contryName, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.countWhiteOrBlackList());
        query = query.setParameter(1, true).setParameter(2, contryName);
        return (Integer) query.getSingleResult();
    }

    @Override
    public void deleteIp(IpAddress address) {
        entityManager.remove(address);
    }

    @Override
    public <T extends IpAddress> List<? extends IpAddress> findBlackList(int from, int count, IpQueryEnum myType) {
        return findIpListByRange(from, count, false, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findBlackList(IpQueryEnum myType) {
        return findIpList(false, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findBlackListByCityName(int from, int count, String cityName,
            IpQueryEnum myType) {
        return findWhiteOrBlackListByCityName(from, count, cityName, false, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findBlackListByCityName(String cityName, IpQueryEnum myType) {
        return findWhiteOrBlackListByCityName(cityName, false, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findBlackListByCountryName(int from, int count, String contryName,
            IpQueryEnum myType) {
        return findWhiteOrBlackListByCountyName(from, count, contryName, false, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findBlackListByCountryName(String contryName, IpQueryEnum myType) {
        return findWhiteOrBlackListByCountyName(contryName, false, myType);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> T findByAddress(String address, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findByAddress()).setParameter(1, address);
        return (T) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountriesBlackList(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findCountriesWhiteOrBlackList());
        query = query.setParameter(1, false);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountriesWhiteList(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findCountriesWhiteOrBlackList());
        query = query.setParameter(1, true);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    private <T extends IpAddress> List<T> findIpList(boolean whiteList, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackList()).setParameter(1, whiteList);
        return query.getResultList();
    }

    private <T extends IpAddress> List<T> findIpListByRange(int from, int count, boolean whiteList,
            IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackList()).setParameter(1, whiteList);
        return findRange(from, count, query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findListBySource(int sourceId, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findBySource());
        query.setParameter(1, sourceId);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IpAddress> List<T> findUnDefList(IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findUndefinedlist());
        return query.getResultList();
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteList(int from, int count, IpQueryEnum myType) {
        return findIpListByRange(from, count, true, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteList(IpQueryEnum myType) {
        return findIpList(true, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteListByCityName(int from, int count, String cityName,
            IpQueryEnum myType) {
        return findWhiteOrBlackListByCityName(from, count, cityName, true, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteListByCityName(String cityName, IpQueryEnum myType) {
        return findWhiteOrBlackListByCityName(cityName, true, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteListByCountryName(int from, int count, String contryName,
            IpQueryEnum myType) {
        return findWhiteOrBlackListByCountyName(from, count, contryName, true, myType);
    }

    @Override
    public <T extends IpAddress> List<T> findWhiteListByCountyName(String contryName, IpQueryEnum myType) {
        return findWhiteOrBlackListByCountyName(contryName, true, myType);
    }

    private <T extends IpAddress> List<T> findWhiteOrBlackListByCityName(int from, int count, String cityName,
            boolean whiteList, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackListByCity());
        query = query.setParameter(1, whiteList).setParameter(2, cityName);
        return findRange(from, count, query);
    }

    @SuppressWarnings("unchecked")
    private <T extends IpAddress> List<T> findWhiteOrBlackListByCityName(String cityName, boolean whiteList,
            IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackListByCity());
        query = query.setParameter(1, whiteList).setParameter(2, cityName);
        return query.getResultList();
    }

    private <T extends IpAddress> List<T> findWhiteOrBlackListByCountyName(int from, int count, String contryName,
            boolean whiteList, IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackListByCountry());
        query = query.setParameter(1, whiteList).setParameter(2, contryName);
        return findRange(from, count, query);
    }

    @SuppressWarnings("unchecked")
    private <T extends IpAddress> List<T> findWhiteOrBlackListByCountyName(String contryName, boolean whiteList,
            IpQueryEnum myType) {
        Query query = entityManager.createNamedQuery(myType.findWhiteOrBlackListByCountry());
        query = query.setParameter(1, whiteList).setParameter(2, contryName);
        return query.getResultList();
    }

    @Override
    public void removeFromBlackList(IpAddress address) {
        address.setWhiteList(true);
        entityManager.persist(address);
    }

    @Override
    public void removeFromWhiteList(IpAddress address) {
        address.setWhiteList(false);
        entityManager.persist(address);
    }

    @Override
    public void save(IpAddress address) {
        entityManager.persist(address);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void saveList(List<? extends IpAddress> list, int sourceId, IpQueryEnum myType) {

        Source source = entityManager.find(Source.class, sourceId);
        if (source == null) {
            // We can't find source for this Id
            // TODO
        } else {
            if (list.size() < 1) {
                return;
            }

            Query query = entityManager.createNamedQuery(myType.findAll());
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
    public void updateWhiteList(IpQueryEnum myType) {
        if (myType.equals(IpQueryEnum.IP_NOT_VALID)) {
            return;
        }

        Query query = entityManager.createNamedQuery(myType.findAll());
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
                ip.setWhiteList(true);
            } else {
                ip.setWhiteList(false);
            }
            entityManager.persist(ip);
        }
    }

}
