package tc.lv.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
		
		Query q = entityManager.createNamedQuery("findIpV4ByNameInWL");
		try {
			WhiteList obj = (WhiteList) q.setParameter("address", address)
					.getSingleResult();
			entityManager.remove(obj);
		} catch (NoResultException e) {
			// TODO: handle exception
		} catch (NonUniqueResultException e) {
			ArrayList<WhiteList> list = new ArrayList<WhiteList>(q
					.setParameter("address", address).getResultList());
			for (int i = 0; i < list.size(); i++)
				entityManager.remove(list.get(i));
		}
	}

	public void deleteIpV6FromWL(String address) {
		Query q = entityManager.createNamedQuery("findIpV6ByNameInWL");
		try {
			WhiteList obj = (WhiteList) q.setParameter("address", address)
					.getSingleResult();
			entityManager.remove(obj);
		} catch (NoResultException e) {
			// TODO: handle exception
		} catch (NonUniqueResultException e) {
			ArrayList<WhiteList> list = new ArrayList<WhiteList>(q
					.setParameter("address", address).getResultList());
			for (int i = 0; i < list.size(); i++)
				entityManager.remove(list.get(i));
		}
	}

	public void addIpV4toWL(String address) {
		Query q = entityManager.createNamedQuery("findIpV4ByName");
		try {
			IpV4Address obj = (IpV4Address) q.setParameter("address", address)
					.getSingleResult();

			WhiteList wl = new WhiteList(obj);
			entityManager.persist(wl);
		} catch (NoResultException e) {
			IpV4Address ip = new IpV4Address(address, new Date());
			WhiteList wl = new WhiteList(ip);

			entityManager.persist(ip);
			entityManager.persist(wl);
		} catch (NonUniqueResultException e) {
			// TODO: handle exception
		}
	}

	public void addIpV6toWL(String address) {
		Query q = entityManager.createNamedQuery("findIpV6ByName");
		try {
			IpV6Address obj = (IpV6Address) q.setParameter("address", address)
					.getSingleResult();
			WhiteList wl = new WhiteList(obj);
			entityManager.persist(wl);
		} catch (NoResultException e) {
			IpV6Address ip = new IpV6Address(address, new Date());
			WhiteList wl = new WhiteList(ip);

			entityManager.persist(ip);
			entityManager.persist(wl);
		} catch (NonUniqueResultException e) {
			// TODO: handle exception
		}
	}

}
