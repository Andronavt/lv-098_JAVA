package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.Dao;
import tc.lv.dao.IpV4AddressDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.Location;

@Repository
public class IpV4AddressDaoImpl extends Dao implements IpV4AddressDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public IpV4Address findByAddress(String address) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_BY_ADDRESS).setParameter(1, address);
        return (IpV4Address) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV4Address> findBlackList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITE_OR_BLACK_LIST).setParameter(1, false);
        return query.getResultList();
    }

    @Override
    public List<IpV4Address> findBlackList(int from, int count) {
        return findWhiteOrBlackList(from, count, false);
    }

    @SuppressWarnings("unchecked")
    private List<IpV4Address> findWhiteOrBlackList(int from, int count, boolean whiteList) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITE_OR_BLACK_LIST);
        query = query.setParameter(1, whiteList).setFirstResult(from).setMaxResults(count);
        return (List<IpV4Address>) getRange(from, count, query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV4Address> findListBySource(int sourceId) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_BY_SOURCE);
        return query.setParameter(1, sourceId).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV4Address> findWhiteList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITE_OR_BLACK_LIST).setParameter(1, true);
        return query.getResultList();
    }

    @Override
    public List<IpV4Address> findWhiteList(int from, int count) {
        return findWhiteOrBlackList(from, count, true);
    }

    @Override
    public void removeFromBlackList(IpV4Address address) {
        address.setWhiteList(true);
        entityManager.persist(address);
    }

    @Override
    public void removeFromWhiteList(IpV4Address address) {
        address.setWhiteList(false);
        entityManager.persist(address);
    }

    @Override
    public void save(IpV4Address address) {
        entityManager.persist(address);
    }

    @Override
    public IpV4Address update(IpV4Address address) {
        return entityManager.merge(address);
    }

    public List<IpV4Address> findWhiteListByCountyName(String contryName) {
        return findWhiteOrBlackListByCountyName(contryName, true);
    }

    public List<IpV4Address> findBlackListByCountyName(String contryName) {
        return findWhiteOrBlackListByCountyName(contryName, false);
    }

    @SuppressWarnings("unchecked")
    private List<IpV4Address> findWhiteOrBlackListByCountyName(String contryName, boolean whiteList) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY);
        query = query.setParameter(1, whiteList).setParameter(2, contryName);
        return query.getResultList();
    }

    public List<IpV4Address> findWhiteListByCityName(String cityName) {
        return findWhiteOrBlackListByCityName(cityName, true);
    }

    public List<IpV4Address> findBlackListByCityName(String cityName) {
        return findWhiteOrBlackListByCityName(cityName, false);
    }

    @SuppressWarnings("unchecked")
    private List<IpV4Address> findWhiteOrBlackListByCityName(String cityName, boolean whiteList) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY);
        query = query.setParameter(1, whiteList).setParameter(2, cityName);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Location> findLocationWhiteList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_LOCATION_WHITE_OR_BLACK_LIST).setParameter(
                1, true);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Location> findLocationBlackList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_LOCATION_WHITE_OR_BLACK_LIST);
        query = query.setParameter(1, false);
        return query.getResultList();
    }
}
