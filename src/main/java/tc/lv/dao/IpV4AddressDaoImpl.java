package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tc.lv.domain.IpV4Address;

//@Repository
public class IpV4AddressDaoImpl implements IpV4AddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public IpV4Address findByAddress(String address) {

		Query query = entityManager.createNamedQuery(
				IpV4Address.FIND_BY_ADDRESS).setParameter(1, address);
		return (IpV4Address) Dao.find(query);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpV4Address> getBlackList() {

		Query query = entityManager.createNamedQuery(IpV4Address.GET_WHITELIST)
				.setParameter(1, false);
		return query.getResultList();
	}

	@Override
	public List<IpV4Address> getBlackList(int from, int count) {

		return getColorList(from, count, false);
	}

	@SuppressWarnings("unchecked")
	private List<IpV4Address> getColorList(int from, int count,
			boolean whiteList) {
		Query query = entityManager.createNamedQuery(IpV4Address.GET_WHITELIST)
				.setParameter(1, whiteList).setFirstResult(from)
				.setMaxResults(count);
		return (List<IpV4Address>) Dao.getRange(from, count, query);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpV4Address> getListBySource(int sourceId) {

		Query query = entityManager.createNamedQuery(IpV4Address.GET_BY_SOURCE);
		return query.setParameter(1, sourceId).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IpV4Address> getWhiteList() {

		Query query = entityManager.createNamedQuery(IpV4Address.GET_WHITELIST)
				.setParameter(1, true);
		return query.getResultList();
	}

	@Override
	public List<IpV4Address> getWhiteList(int from, int count) {

		return getColorList(from, count, true);
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
}
