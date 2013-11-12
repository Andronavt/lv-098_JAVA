package tc.lv.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

@Repository
public class UndefinedListDaoImpl implements UndefinedListDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public Collection<IpV4Address> loadIpV4List() {
		Query q = entityManager
				.createNamedQuery("IpV4Address.loadUndefinedList");
		ArrayList<IpV4Address> list = new ArrayList<IpV4Address>();
		list.addAll(q.getResultList());
		return list;
	}

	@Override
	public Collection<IpV6Address> loadIpV6List() {
		Query q = entityManager
				.createNamedQuery("IpV6Address.loadUndefinedList");
		ArrayList<IpV6Address> list = new ArrayList<IpV6Address>();
		list.addAll(q.getResultList());
		return list;
	}

}
