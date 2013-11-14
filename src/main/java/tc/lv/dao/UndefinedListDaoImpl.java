package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

@Repository
public class UndefinedListDaoImpl implements UndefinedListDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpV4Address> getIpV4List() {

		return entityManager.createNamedQuery(IpV4Address.GET_UNDEFINEDLIST,
				IpV4Address.class).getResultList();
	}

	@Override
	public List<IpV6Address> getIpV6List() {

		return entityManager.createNamedQuery(IpV6Address.GET_UNDEFINEDLIST,
				IpV6Address.class).getResultList();
	}
}
