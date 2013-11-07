package tc.lv.dao;

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
public class DownloaderDaoImpl implements DownloaderDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public void saveIpV4List(List<IpV4Address> list, int sourceId) {

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
	public void saveIpV6List(List<IpV6Address> list, int sourceId) {

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
	public void saveNotValIpList(List<NotValidIp> list, int sourceId) {

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
	public void save(ParserResults parser) {
		System.out.println("IPV4 PUSH");
		saveIpV4List(parser.getIp4list(), parser.getSourceId());
		System.out.println("IPV6 PUSH");
		saveIpV6List(parser.getIp6list(), parser.getSourceId());
		System.out.println("NOT VALOD PUSH PUSH");
		saveNotValIpList(parser.getNotValidList(), parser.getSourceId());
	}

}
