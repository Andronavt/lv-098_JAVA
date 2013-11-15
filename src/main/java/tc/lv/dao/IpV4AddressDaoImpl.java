package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;

@Repository
public class IpV4AddressDaoImpl extends Dao implements IpV4AddressDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    @Override
    public IpV4Address findByAddress(String address) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_BY_ADDRESS).setParameter(1, address);
        return (IpV4Address) find(query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<IpV4Address> getBlackList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITELIST).setParameter(1, false);
        return query.getResultList();
    }

    @Override
    public List<IpV4Address> getBlackList(int from, int count) {
        return getIpList(from, count, false);
    }

    @SuppressWarnings("unchecked")
    private List<IpV4Address> getIpList(int from, int count, boolean whiteList) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITELIST).setParameter(1, whiteList)
                .setFirstResult(from).setMaxResults(count);
        return (List<IpV4Address>) getRange(from, count, query);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<IpV4Address> getListBySource(int sourceId) {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_BY_SOURCE);
        return query.setParameter(1, sourceId).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<IpV4Address> getWhiteList() {
        Query query = entityManager.createNamedQuery(IpV4Address.FIND_WHITELIST).setParameter(1, true);
        return query.getResultList();
    }

    @Override
    public List<IpV4Address> getWhiteList(int from, int count) {
        return getIpList(from, count, true);
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
}
