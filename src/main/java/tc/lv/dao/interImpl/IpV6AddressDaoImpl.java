package tc.lv.dao.interImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.Dao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.domain.IpV6Address;

@Repository
public class IpV6AddressDaoImpl extends Dao implements IpV6AddressDao {

    @PersistenceContext(name = PERSISTENCE_CONTEXT)
    private EntityManager entityManager;

    @Override
    public IpV6Address findByAddress(String address) {
        Query query = entityManager.createNamedQuery(IpV6Address.FIND_BY_ADDRESS).setParameter(1, address);
        return (IpV6Address) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV6Address> getBlackList() {
        Query query = entityManager.createNamedQuery(IpV6Address.FIND_WHITE_OR_BLACK_LIST).setParameter(1, false);
        return query.getResultList();
    }

    @Override
    public List<IpV6Address> getBlackList(int from, int count) {
        return findWhiteOrBlackList(from, count, false);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV6Address> getListBySource(int sourceId) {
        Query query = entityManager.createNamedQuery(IpV6Address.FIND_BY_SOURCE);
        query.setParameter(1, sourceId);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV6Address> getWhiteList() {
        Query query = entityManager.createNamedQuery(IpV6Address.FIND_WHITE_OR_BLACK_LIST).setParameter(1, true);
        return query.getResultList();
    }

    @Override
    public List<IpV6Address> getWhiteList(int from, int count) {
        return findWhiteOrBlackList(from, count, true);
    }

    @SuppressWarnings("unchecked")
    private List<IpV6Address> findWhiteOrBlackList(int from, int count, boolean whiteList) {
        Query query = entityManager.createNamedQuery(IpV6Address.FIND_WHITE_OR_BLACK_LIST);
        query = query.setParameter(1, whiteList).setFirstResult(from).setMaxResults(count);
        return (List<IpV6Address>) getRange(from, count, query);
    }

    @Override
    public void removeFromBlackList(IpV6Address address) {
        address.setWhiteList(true);
        entityManager.persist(address);
    }

    @Override
    public void removeFromWhiteList(IpV6Address address) {
        address.setWhiteList(false);
        entityManager.persist(address);
    }

    @Override
    public void save(IpV6Address address) {
        entityManager.persist(address);
    }

    @Override
    public IpV6Address update(IpV6Address address) {
        return entityManager.merge(address);
    }
}
