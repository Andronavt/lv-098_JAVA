package tc.lv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV6Address;

@Repository
public class IpV6AddressDaoImpl implements IpV6AddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpV6Address> getListBySource(int sourceId) {
		Query query = entityManager.createNamedQuery("IpV6Address.getBySource");
		query.setParameter("id", sourceId);
		List<IpV6Address> list = query.getResultList();
		return list;
	}

	@Override
	public List<IpV6Address> getWhiteList(int from, int count) {
		Query query = entityManager
				.createNamedQuery("IpV6Address.getWhiteList")
				.setParameter("whitelist", true).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public List<IpV6Address> getWhiteList() {
		Query query = entityManager
				.createNamedQuery("IpV6Address.getWhiteList").setParameter(
						"whitelist", true);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public IpV6Address findByAddress(String address) {
		Query query = entityManager.createNamedQuery(
				"IpV6Address.findByAddress").setParameter("address", address);
		try {
			IpV6Address object = (IpV6Address) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void save(IpV6Address address) {
		entityManager.persist(address);

	}

	@Override
	public void removeFromWhiteList(IpV6Address address) {
		address.setWhiteList(false);
		entityManager.persist(address);
	}

	@Override
	public List<IpV6Address> getBlackList(int from, int count) {
		Query query = entityManager
				.createNamedQuery("IpV6Address.getWhiteList")
				.setParameter("whitelist", false).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public List<IpV6Address> getBlackList() {
		Query query = entityManager
				.createNamedQuery("IpV6Address.getWhiteList").setParameter(
						"whitelist", false);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public void deleteFromBlackList(IpV6Address address) {
		address.setWhiteList(true);
		entityManager.persist(address);

	}
}
