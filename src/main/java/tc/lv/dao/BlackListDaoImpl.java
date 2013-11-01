package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

@Repository
public class BlackListDaoImpl implements BlackListDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public BlackListDaoImpl() {

	}

	@Override
	public void deleteIpV4FromBL(String address) {
		IpV4Address delObj = entityManager
				.createNamedQuery("IpV4Address.findByNameInBlackList",
						IpV4Address.class).setParameter("ipV4_id", address)
				.getSingleResult();
		entityManager.remove(delObj);
	}

	@Override
	public void deleteIpV6FromBL(String address) {
		IpV6Address delObj = entityManager
				.createNamedQuery("IpV6Address.findByNameInBlackList",
						IpV6Address.class).setParameter("ipV6_id", address)
				.getSingleResult();
		entityManager.remove(delObj);
	}

}
