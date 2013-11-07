package tc.lv.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.utils.ParserResults;

@Repository
public class SourceDaoImpl implements SourceDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public SourceDaoImpl() {

	}

	public void addNewFeed(String typeofList, String rank, String sourceName,
			String url) {
		entityManager.persist(new Source(typeofList, rank, sourceName, url));
	}

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
		tempIp.addElementToSourceSet(tempSource);
		entityManager.persist(tempIp);
	}

	@Override
	public void setIpV6Address(String ip, int sourceId) {
		Source tempSource = entityManager.find(Source.class, sourceId);
		IpV6Address tempIp = new IpV6Address(ip, new Date());
		tempSource.addIpToV6Set(tempIp);
		entityManager.persist(tempSource);

	}

	@Override
	public List<Source> getListOfSources() {
		return entityManager.createQuery("from Source").getResultList();
	}

	@Override
	public void deleteFeed(String sourceName) {
		sourceName = sourceName.trim();
		System.err.println(sourceName);
		Query query = entityManager.createNamedQuery("Source.findByName",
				Source.class).setParameter("sourceName", sourceName);
		Source tempSource = (Source) query.getSingleResult();
		System.out.println(tempSource.getSourceName());
		entityManager.remove(tempSource);
	}

	@Override
	public void updateSourceIpV4List(List<IpV4Address> list, int sourceId) {

		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			System.out.println("NULL");
		} else {
			Query query = entityManager.createQuery("from IpV4Address");
			Set<IpV4Address> set = new HashSet<IpV4Address>();
			set.addAll(query.getResultList());

			for (IpV4Address ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"findIpV4ByName").setParameter("address",
							ip.getAddress());
					IpV4Address temp = (IpV4Address) query2.getSingleResult();
					temp.addElementToSourceSet(source);
					entityManager.persist(temp);
				}
			}
		}
	}

	@Override
	public void updateSourceIpV6List(List<IpV6Address> list, int sourceId) {

		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			System.out.println("NULL");
		} else {
			Query query = entityManager.createQuery("from IpV6Address");
			Set<IpV6Address> set = new HashSet<IpV6Address>();
			set.addAll(query.getResultList());

			for (IpV6Address ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"findIpV6ByName").setParameter("address",
							ip.getAddress());
					IpV6Address temp = (IpV6Address) query2.getSingleResult();
					temp.addElementToSourceSet(source);
					entityManager.persist(temp);
				}
			}
		}
	}

	@Override
	public void updateSourceNotValIpList(List<NotValidIp> list, int sourceId) {

		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			System.out.println("NULL");
		} else {
			Query query = entityManager.createQuery("from NotValidIp");
			Set<NotValidIp> set = new HashSet<NotValidIp>();
			set.addAll(query.getResultList());

			for (NotValidIp ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"findNotValName").setParameter("address",
							ip.getAddress());
					NotValidIp temp = (NotValidIp) query2.getSingleResult();
					temp.addElementToSourceSet(source);
					entityManager.persist(temp);
				}
			}
		}
	}

	@Override
	public void updateSourceIpList(ParserResults parser) {
		System.out.println("IPV4 PUSH");
		updateSourceIpV4List(parser.getIp4list(), parser.getSourceId());
		System.out.println("IPV6 PUSH");
		updateSourceIpV6List(parser.getIp6list(), parser.getSourceId());
		System.out.println("NOT VALOD PUSH PUSH");
		updateSourceNotValIpList(parser.getNotValidList(), parser.getSourceId());
	}

	@Override
	public Source loadSourceByName(String sourceName) {
		Query query = entityManager.createNamedQuery("Source.findByName",
				Source.class);
		query.setParameter("sourceName", sourceName);

		return (Source) query.getSingleResult();
	}

}
