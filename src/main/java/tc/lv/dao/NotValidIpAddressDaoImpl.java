package tc.lv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.NotValidIp;

@Repository
public class NotValidIpAddressDaoImpl implements NotValidIpAddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<NotValidIp> loadAll(int sourceId) {
		List<NotValidIp> list = new ArrayList<NotValidIp>();
		Query q = entityManager
			.createNamedQuery(
				"NotValidIp.loadBySource").setParameter("id", sourceId);
		list.addAll(q.getResultList());
		return list;
	}
	@Override
	    public List<NotValidIp> loadNotValidIpList(int from, int count) {
		Query q = entityManager.createNamedQuery("NotValidIp.loadAll").setFirstResult(from).setMaxResults(count);
		ArrayList<NotValidIp> list = new ArrayList<NotValidIp>();
		list.addAll(q.getResultList());
		return list;
	    }
}
