package tc.lv.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import tc.lv.domain.dbEntities.IpV4Address;
import tc.lv.domain.dbEntities.IpV6Address;
import tc.lv.domain.dbEntities.NotValidIp;
import tc.lv.domain.dbEntities.Source;

public class SourceDaoImpl implements SourceDao {

	private EntityManager entityManager;

	public SourceDaoImpl() {

	}

	/*
	 * public void addIpV4SetToSource(int sourceId, List<IpV4Address>
	 * ipV4InputList) { EntityManagerFactory emf = Persistence
	 * .createEntityManagerFactory("primary"); entityManager =
	 * emf.createEntityManager(); entityManager.getTransaction().begin();
	 * System.out.println("INPUT IPV4 SIZE= " + ipV4InputList.size()); Source
	 * tempSource = entityManager.find(Source.class, sourceId); Set<IpV4Address>
	 * tempSet = new HashSet<IpV4Address>( tempSource.getIpv4Set());
	 * tempSet.addAll(ipV4InputList); tempSource.setIpv4Set(tempSet);
	 * entityManager.persist(tempSource);
	 * 
	 * entityManager.getTransaction().commit(); }
	 * 
	 * public void addIpV6SetToSource(int sourceId, List<IpV6Address>
	 * ipV6InputList) { EntityManagerFactory emf = Persistence
	 * .createEntityManagerFactory("primary"); entityManager =
	 * emf.createEntityManager(); entityManager.getTransaction().begin();
	 * System.out.println("INPUT IPV6 SIZE= " + ipV6InputList.size()); Source
	 * tempSource = entityManager.find(Source.class, sourceId); Set<IpV6Address>
	 * tempSet = new HashSet<IpV6Address>( tempSource.getIpv6Set());
	 * tempSet.addAll(ipV6InputList); tempSource.setIpv6Set(tempSet);
	 * entityManager.persist(tempSource);
	 * entityManager.getTransaction().commit(); }
	 * 
	 * public void addNotValidSetToSource(int sourceId, List<NotValidIp>
	 * notValidInputList) { EntityManagerFactory emf = Persistence
	 * .createEntityManagerFactory("primary"); entityManager =
	 * emf.createEntityManager(); entityManager.getTransaction().begin();
	 * System.out.println("INPUT IPV6 SIZE= " + notValidInputList.size());
	 * Source tempSource = entityManager.find(Source.class, sourceId);
	 * Set<NotValidIp> tempSet = new HashSet<NotValidIp>(
	 * tempSource.getNotValidSet()); if (notValidInputList.size() > 0) {
	 * tempSet.addAll(notValidInputList); } tempSource.setNotValidSet(tempSet);
	 * entityManager.persist(tempSource);
	 * entityManager.getTransaction().commit(); }
	 */
	@Override
	public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
		List<IpV4Address> list = new ArrayList<IpV4Address>(entityManager.find(
				Source.class, sourceId).getIpv4Set());
		return list;
	}

	@Override
	public List<IpV6Address> getIpV6ListFromSource(int sourceId) {
		List<IpV6Address> list = new ArrayList<IpV6Address>(entityManager.find(
				Source.class, sourceId).getIpv6Set());
		return list;
	}

	@Override
	public List<NotValidIp> getNotValidIpFromSource(int sourceId) {
		List<NotValidIp> list = new ArrayList<NotValidIp>(entityManager.find(
				Source.class, sourceId).getNotValidSet());
		return list;
	}

	@Override
	public List<IpV4Address> getFirstIpV4ListFromSource(int sourceId,
			int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IpV6Address> getFirstIpV6ListFromSource(int sourceId,
			int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotValidIp> getFirstNotValidIpListFromSource(int sourceId,
			int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIpV4Address(String ip, int sourceId) {
		Source tempSource = entityManager.find(Source.class, sourceId);
		IpV4Address tempIp = new IpV4Address(ip, new Date());
		tempSource.addIpToV4Set(tempIp);
		entityManager.persist(tempSource);
	}

	@Override
	public void setIpV6Address(String ip, int sourceId) {
		Source tempSource = entityManager.find(Source.class, sourceId);
		IpV6Address tempIp = new IpV6Address(ip, new Date());
		tempSource.addIpToV6Set(tempIp);
		entityManager.persist(tempSource);

	}

}
