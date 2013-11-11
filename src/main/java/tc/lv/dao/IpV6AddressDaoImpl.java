package tc.lv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV6Address;

@Repository
public class IpV6AddressDaoImpl implements IpV6AddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpV6Address> loadAll(int sourceId) {
		List<IpV6Address> list = new ArrayList<IpV6Address>();
		Query q = entityManager
			.createNamedQuery(
				"IpV6Address.loadBySource").setParameter("id", sourceId);
		list.addAll(q.getResultList());
		return list;
	}
}
