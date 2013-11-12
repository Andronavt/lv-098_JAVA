package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.NotValidIp;

@Repository
public class NotValidIpAddressDaoImpl implements NotValidIpAddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<NotValidIp> getListBySource(int sourceId) {
		Query query = entityManager.createNamedQuery("NotValidIp.loadBySource");
		query.setParameter("id", sourceId);
		List<NotValidIp> list = query.getResultList();
		return list;
	}
}
