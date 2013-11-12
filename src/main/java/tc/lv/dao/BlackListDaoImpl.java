package tc.lv.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.Source;

@Repository
public class BlackListDaoImpl implements BlackListDao {
	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpV4Address> loadIpV4ListByRange(int from, int count) {
		Query q = entityManager.createNamedQuery("IpV4Address.loadWhiteList")
				.setParameter("whitelist", false).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(q.getResultList());
		return list;
	}

	@Override
	public List<IpV6Address> loadIpV6ListByRange(int from, int count) {
		Query q = entityManager.createNamedQuery("IpV6Address.loadWhiteList")
				.setParameter("whitelist", false).setFirstResult(from)
				.setMaxResults(count);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(q.getResultList());
		return list;
	}

	@Override
	public List<IpV4Address> loadAllIpV4List() {
		Query q = entityManager.createNamedQuery("IpV4Address.loadWhiteList")
				.setParameter("whitelist", false);
		;
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(q.getResultList());
		return list;
	}

	@Override
	public List<IpV6Address> loadAllIpV6List() {
		Query q = entityManager.createNamedQuery("IpV6Address.loadWhiteList")
				.setParameter("whitelist", false);
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(q.getResultList());
		return list;
	}

	@Override
	public void saveIpV4(String address) {
		Query q = entityManager.createNamedQuery("IpV4Address.loadByName")
				.setParameter("address", address);
		IpV4Address obj = null;
		try {
			obj = (IpV4Address) q.getSingleResult();
			obj.setWhiteList(false);
			entityManager.persist(obj);
		} catch (NoResultException e) {
			// Adding to admin source..... need source id
			// TODO
			Source source = entityManager.find(Source.class, 1);
			obj = new IpV4Address();
			obj.setAddress(address);
			obj.setDateAdded(new Date());
			obj.setWhiteList(false);
			obj.getSourceSet().add(source);
			entityManager.persist(obj);
		}
	}

	@Override
	public void saveIpV6(String address) {
		Query q = entityManager.createNamedQuery("IpV6Address.loadByName")
				.setParameter("address", address);
		IpV6Address obj = null;
		try {
			obj = (IpV6Address) q.getSingleResult();
			obj.setWhiteList(false);
			entityManager.persist(obj);
		} catch (NoResultException e) {
			// Adding to admin source..... need source id
			// TODO
			Source source = entityManager.find(Source.class, 1);
			obj = new IpV6Address();
			obj.setAddress(address);
			obj.setDateAdded(new Date());
			obj.setWhiteList(false);
			obj.getSourceSet().add(source);
			entityManager.persist(obj);
		}
	}

	@Override
	public void saveIpV4List(Collection<String> list) {
		for (String address : list) {
			saveIpV4(address);
		}
	}

	@Override
	public void saveIpV6List(Collection<String> list) {
		for (String address : list) {
			saveIpV6(address);
		}
	}

	@Override
	public void deleteIpV4(String address) {
		Query q = entityManager.createNamedQuery("IpV4Address.loadBlackByName")
				.setParameter("address", address);
		IpV4Address obj = (IpV4Address) q.getSingleResult();
		obj.setWhiteList(true);
		entityManager.persist(obj);
	}

	@Override
	public void deleteIpV6(String address) {
		Query q = entityManager.createNamedQuery("IpV6Address.loadBlackByName")
				.setParameter("address", address);
		IpV6Address obj = (IpV6Address) q.getSingleResult();
		obj.setWhiteList(true);
		entityManager.persist(obj);
	}
}