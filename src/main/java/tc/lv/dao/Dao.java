package tc.lv.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import tc.lv.domain.IpAddressImpl;

public class Dao {

	public static Object find(Query query) {
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<? extends IpAddressImpl> getRange(int from, int count,
			Query query) {
		return query.setFirstResult(from).setMaxResults(count).getResultList();
	}
}
