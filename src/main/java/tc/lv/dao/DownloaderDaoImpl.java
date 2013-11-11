
package tc.lv.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddress;
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
			// TODO
		} else {
			Query query = entityManager.createNamedQuery("IpV4Address.loadAll",
					IpV4Address.class);
			Set<IpV4Address> set = new HashSet<IpV4Address>();
			set.addAll(query.getResultList());

			for (IpV4Address ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"IpV4Address.loadByName").setParameter("address",
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
			// TODO
		} else {
			Query query = entityManager.createNamedQuery("IpV6Address.loadAll",
					IpV6Address.class);
			Set<IpV6Address> set = new HashSet<IpV6Address>();
			set.addAll(query.getResultList());

			for (IpV6Address ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"IpV6Address.loadByName").setParameter("address",
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
			// TODO
		} else {
			Query query = entityManager.createNamedQuery("NotValidIp.loadAll",
					NotValidIp.class);
			Set<NotValidIp> set = new HashSet<NotValidIp>();
			set.addAll(query.getResultList());

			for (NotValidIp ip : list) {
				if (set.add(ip)) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
				} else {
					Query query2 = entityManager.createNamedQuery(
							"NotValidIp.loadByName").setParameter("address",
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
		saveIpV4List(parser.getIpV4List(), parser.getSourceId());
		saveIpV6List(parser.getIpV6List(), parser.getSourceId());
		saveNotValIpList(parser.getNotValidList(), parser.getSourceId());
	}

	@Override
	public void updateWhiteList() {
		Query query = entityManager.createNamedQuery(
				"IpAddress.loadAllValidIp", IpAddress.class);
		List<IpAddress> list = query.getResultList();

		for (IpAddress ip : list) {
			Set<Source> set = ip.getSourceSet();
			if (set == null)
				continue;
			Iterator<Source> it = set.iterator();
			double blackRank = 0;
			double whiteRank = 0;
			while (it.hasNext()) {
				Source source = it.next();
				if (source.getListType().equals("whitelist")) {
					whiteRank += source.getRank();
				} else if (source.getListType().equals("blacklist")) {
					blackRank += source.getRank();
				}
			}

			if (whiteRank > blackRank) {
				ip.setWhiteList(true);
			} else {
				ip.setWhiteList(false);
			}
			entityManager.persist(ip);
		}
	}

}
