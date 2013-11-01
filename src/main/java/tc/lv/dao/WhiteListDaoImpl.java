package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.WhiteList;

@Repository
public class WhiteListDaoImpl implements WhiteListDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public WhiteListDaoImpl() {

	}

	public void deleteIpV4FromWL(String address) {
		// WhiteList delObj = (WhiteList) entityManager
		// .createNamedQuery("findIpV4ByNameInWL")
		// .setParameter("address", address).getSingleResult();
		// entityManager.remove(delObj);
		Query q = entityManager.createNamedQuery("findIpV4ByNameInWL");
		WhiteList wl = (WhiteList) q.setParameter("address", address)
				.getSingleResult();
		if (wl == null) {
			throw new RuntimeException("Didn't find that IpAddress");
		} else {
			entityManager.remove(wl);
		}
	}

	public void deleteIpV6FromWL(String address) {
		WhiteList delObj = entityManager
				.createNamedQuery("findIpV6ByNameInWL", WhiteList.class)
				.setParameter("address", address).getSingleResult();
		entityManager.remove(delObj);
	}

}
