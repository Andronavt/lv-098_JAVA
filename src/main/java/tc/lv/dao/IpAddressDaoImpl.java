package tc.lv.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpAddressImpl;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;

@Repository
public class IpAddressDaoImpl implements IpAddressDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public IpAddressImpl findByAddress(String address,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		Query query = entityManager.createNamedQuery(
				ipClass.newInstance().getFindByAddress()).setParameter(1,
				address);
		return (IpAddressImpl) Dao.find(query);
	}

	@Override
	public List<? extends IpAddress> getBlackList(
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		return getColorList(false, ipClass);
	}

	@Override
	public List<? extends IpAddress> getBlackList(int from, int count,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		return getColorListByRange(from, count, false, ipClass);
	}

	@SuppressWarnings("unchecked")
	private List<? extends IpAddress> getColorList(boolean whiteList,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		Query query = entityManager.createNamedQuery(
				ipClass.newInstance().getGetWhitelist()).setParameter(1,
				whiteList);
		return query.getResultList();
	}

	private List<? extends IpAddress> getColorListByRange(int from, int count,
			boolean whiteList, Class<? extends IpAddress> ipClass)
			throws InstantiationException, IllegalAccessException {

		Query query = entityManager.createNamedQuery(
				ipClass.newInstance().getGetWhitelist()).setParameter(1,
				whiteList);
		return (List<? extends IpAddress>) Dao.getRange(from, count, query);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends IpAddress> getListBySource(int sourceId,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		Query query = entityManager.createNamedQuery(ipClass.newInstance()
				.getGetBySource());
		query.setParameter(1, sourceId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends IpAddress> getUnDefList(
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		Query query = entityManager.createNamedQuery(ipClass.newInstance()
				.getGetUndefinedlist());
		return query.getResultList();
	}

	@Override
	public List<? extends IpAddress> getWhiteList(
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		return getColorList(true, ipClass);
	}

	@Override
	public List<? extends IpAddress> getWhiteList(int from, int count,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException {

		return getColorListByRange(from, count, true, ipClass);
	}

	@Override
	public void removeFromBlackList(IpAddressImpl address,
			Class<? extends IpAddress> ipClass) {

		address.setWhiteList(true);
		entityManager.persist(address);
	}

	@Override
	public void removeFromWhiteList(IpAddressImpl address,
			Class<? extends IpAddress> ipClass) {

		address.setWhiteList(false);
		entityManager.persist(address);
	}

	@Override
	public void save(IpAddressImpl address) {

		entityManager.persist(address);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveList(List<? extends IpAddressImpl> list, int sourceId)
			throws InstantiationException, IllegalAccessException {

		Source source = entityManager.find(Source.class, sourceId);
		if (source == null) {
			// We can't find source for this Id
			// TODO
		} else {
			if (list.size() < 1) {
				return;
			}

			Query query = entityManager.createNamedQuery(list.get(0).getClass()
					.newInstance().getGetAll());
			Map<String, IpAddressImpl> map = new HashMap<String, IpAddressImpl>();

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
