package tc.lv.dao;

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
	public Collection<IpV4Address> getIpV4List() {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getUndefinedList");
		return query.getResultList();
	}

	@Override
	public Collection<IpV6Address> getIpV6List() {
		Query query = entityManager
				.createNamedQuery("IpV6Address.getUndefinedList");
		return query.getResultList();
	}
}
