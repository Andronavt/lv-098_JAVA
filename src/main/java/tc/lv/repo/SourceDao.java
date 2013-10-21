package tc.lv.repo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tc.lv.domain.dbEntities.IpV4Address;
import tc.lv.domain.dbEntities.IpV6Address;
import tc.lv.domain.dbEntities.NotValidIp;
import tc.lv.domain.dbEntities.Source;

public class SourceDao {
	private EntityManager entityManager;
	public SourceDao() {

	}
	public void addIpV4SetToSource(int sourceId, List<IpV4Address> ipV4InputList) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("primary");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("INPUT IPV4 SIZE= " + ipV4InputList.size());
		Source tempSource = entityManager.find(Source.class, sourceId);
		Set<IpV4Address> tempSet = new HashSet<IpV4Address>(
				tempSource.getIpv4Set());
		tempSet.addAll(ipV4InputList);
		tempSource.setIpv4Set(tempSet);
		entityManager.persist(tempSource);

		entityManager.getTransaction().commit();
	}

	public void addIpV6SetToSource(int sourceId, List<IpV6Address> ipV6InputList) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("primary");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("INPUT IPV6 SIZE= " + ipV6InputList.size());
		Source tempSource = entityManager.find(Source.class, sourceId);
		Set<IpV6Address> tempSet = new HashSet<IpV6Address>(
				tempSource.getIpv6Set());
		tempSet.addAll(ipV6InputList);
		tempSource.setIpv6Set(tempSet);
		entityManager.persist(tempSource);
		entityManager.getTransaction().commit();
	}

	public void addNotValidSetToSource(int sourceId,
			List<NotValidIp> notValidInputList) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("primary");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("INPUT IPV6 SIZE= " + notValidInputList.size());
		Source tempSource = entityManager.find(Source.class, sourceId);
		Set<NotValidIp> tempSet = new HashSet<NotValidIp>(
				tempSource.getNotValidSet());
		if (notValidInputList.size() > 0) {
			tempSet.addAll(notValidInputList);
		}
		tempSource.setNotValidSet(tempSet);
		entityManager.persist(tempSource);
		entityManager.getTransaction().commit();
	}

}
