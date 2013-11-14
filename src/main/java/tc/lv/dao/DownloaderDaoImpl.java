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

import tc.lv.domain.IpAddressImpl;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.utils.ParserResults;

//@Repository
public class DownloaderDaoImpl implements DownloaderDao {

	private static final Logger loggerInfo = Logger.getLogger("infoLog");

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	@Deprecated
	public void save(ParserResults parser) {
		loggerInfo.info("START UPDATE IpV4List (" + parser.getIpV4List().size()
				+ " ip's)");
		saveList(parser.getIpV4List(), parser.getSourceId());
		loggerInfo.info("START UPDATE IpV6List (" + parser.getIpV6List().size()
				+ " ip's)");
		saveList(parser.getIpV6List(), parser.getSourceId());
		loggerInfo.info("START UPDATE NotValidList ("
				+ parser.getNotValidList().size() + " ip's)");
		saveList(parser.getNotValidList(), parser.getSourceId());
		loggerInfo.info("UPDATE ALL LISTS IN CURRENT SOURCE");
	}

	@Override
	@Deprecated
	public void saveList(List<? extends IpAddressImpl> list, int sourceId) {
		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			// TODO
		} else {
			if (list.size() < 1) {
				return;
			}
			String queryName = list.get(0).getClass().getSimpleName();
			Query query = entityManager.createNamedQuery(queryName + ".getAll");
			Map<String, IpAddressImpl> map = new HashMap<String, IpAddressImpl>();

			@SuppressWarnings("unchecked")
			List<IpAddressImpl> listFromDB = query.getResultList();
			for (IpAddressImpl ip : listFromDB) {
				map.put(ip.getAddress(), ip);
			}

			for (IpAddressImpl ip : list) {
				if (!map.containsKey(ip.getAddress())) {
					ip.getSourceSet().add(source);
					entityManager.persist(ip);
					map.put(ip.getAddress(), ip);
				} else {
					IpAddressImpl temp = map.get(ip.getAddress());
					temp.getSourceSet().add(source);
					entityManager.persist(temp);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	public void updateWhiteList(Class<? extends IpAddressImpl> ipClass)
			throws InstantiationException, IllegalAccessException {

		if (ipClass.isAssignableFrom(NotValidIp.class)) {
			return;
		}

		Query query = entityManager.createNamedQuery(ipClass.newInstance()
				.getGetAll());
		List<? extends IpAddressImpl> list = query.getResultList();

		for (IpAddressImpl ip : list) {

			Set<Source> set = ip.getSourceSet();
			if (set == null) {
				continue;
			}

			Iterator<Source> it = set.iterator();
			double blackRank = 0;
			double whiteRank = 0;
			while (it.hasNext()) {
				Source source = it.next();
				if (source.getListType().equals(Source.WHITE_LIST)) {
					whiteRank += source.getRank();
				} else if (source.getListType().equals(Source.BLACK_LIST)) {
					blackRank += source.getRank();
				} else {
					// Maybe throw new
					// MyException("Something wrong... Can't find whitelist neither blacklist mark")
					// TODO
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