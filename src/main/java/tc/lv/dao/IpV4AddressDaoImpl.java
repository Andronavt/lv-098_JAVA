package tc.lv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;

@Repository
public class IpV4AddressDaoImpl implements IpV4AddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpV4Address> getListBySource(int sourceId) {
		Query query = entityManager.createNamedQuery("IpV4Address.getBySource");
		query.setParameter("id", sourceId);
		List<IpV4Address> list = query.getResultList();
		return list;
	}

	@Override
	public List<IpV4Address> getWhiteList(int from, int count) {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList")
				.setParameter("whitelist", true).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public List<IpV4Address> getWhiteList() {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList").setParameter(
						"whitelist", true);
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public IpV4Address findByAddress(String address) {
		Query query = entityManager.createNamedQuery(
				"IpV4Address.findByAddress").setParameter("address", address);
		try {
			IpV4Address object = (IpV4Address) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void save(IpV4Address address) {
		entityManager.persist(address);

	}

	@Override
	public void removeFromWhiteList(IpV4Address address) {
		address.setWhiteList(false);
		entityManager.persist(address);
	}

	@Override
	public List<IpV4Address> getBlackList(int from, int count) {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList")
				.setParameter("whitelist", false).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public List<IpV4Address> getBlackList() {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList").setParameter(
						"whitelist", false);
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(query.getResultList());
		return list;
	}

	@Override
	public void deleteFromBlackList(IpV4Address address) {
		address.setWhiteList(true);
		entityManager.persist(address);
	}

}
