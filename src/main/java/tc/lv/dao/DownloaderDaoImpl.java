package tc.lv.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.utils.ParserResults;

@Repository
public class DownloaderDaoImpl implements DownloaderDao {
	private static final Logger loggerInfo = Logger.getLogger("infoLog");

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public void saveIpV4List(List<IpV4Address> list, int sourceId) {
		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			// TODO
		} else {
			Query query = entityManager.createNamedQuery("IpV4Address.getAll",
					IpV4Address.class);
			Map<String, IpV4Address> map = new HashMap<String, IpV4Address>();
			List<IpV4Address> listFromDB = query.getResultList();
			for (IpV4Address ip : listFromDB) {
				map.put(ip.getAddress(), ip);
			}

			for (IpV4Address ip : list) {
				if (!map.containsKey(ip.getAddress())) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
					map.put(ip.getAddress(), ip);
				} else {
					IpV4Address temp = map.get(ip.getAddress());
					temp.getSourceSet().add(source);
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
			Map<String, IpV6Address> map = new HashMap<String, IpV6Address>();
			List<IpV6Address> listFromDB = query.getResultList();
			for (IpV6Address ip : listFromDB) {
				map.put(ip.getAddress(), ip);
			}

			for (IpV6Address ip : list) {
				if (!map.containsKey(ip.getAddress())) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
					map.put(ip.getAddress(), ip);
				} else {
					IpV6Address temp = map.get(ip.getAddress());
					temp.getSourceSet().add(source);
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
			long start = System.currentTimeMillis();
			Query query = entityManager.createNamedQuery("NotValidIp.loadAll",
					NotValidIp.class);
			Map<String, NotValidIp> map = new HashMap<String, NotValidIp>();
			start = System.currentTimeMillis();
			List<NotValidIp> listFromDB = query.getResultList();
			for (NotValidIp ip : listFromDB) {
				map.put(ip.getAddress(), ip);
			}

			for (NotValidIp ip : list) {
				if (!map.containsKey(ip.getAddress())) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
					map.put(ip.getAddress(), ip);
				} else {
					NotValidIp temp = map.get(ip.getAddress());
					temp.getSourceSet().add(source);
					entityManager.persist(temp);
				}
			}
		}
	}

	@Override
	public void save(ParserResults parser) {
		loggerInfo.info("START UPDATE IpV4List (" + parser.getIpV4List().size()
				+ " ip's)");
		saveIpV4List(parser.getIpV4List(), parser.getSourceId());
		loggerInfo.info("START UPDATE IpV6List (" + parser.getIpV6List().size()
				+ " ip's)");
		saveIpV6List(parser.getIpV6List(), parser.getSourceId());
		loggerInfo.info("START UPDATE NotValidList ("
				+ parser.getNotValidList().size() + " ip's)");
		saveNotValIpList(parser.getNotValidList(), parser.getSourceId());
		loggerInfo.info("UPDATE ALL LISTS IN CURRENT SOURCE");
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