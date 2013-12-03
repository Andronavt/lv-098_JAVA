package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.GeoIpException;
import tc.lv.utils.GeoIpUtil;

@Repository
public class IpAddressDaoImpl extends DaoAbstract implements IpAddressDao {

	@PersistenceContext(name = PERSISTENCE_UNIT_NAME)
	private EntityManager entityManager;
	private static final Logger LOGGER = Logger
			.getLogger(IpAddressDaoImpl.class);
	private static GeoIpUtil geoIpUtil = null;

	public IpAddressDaoImpl() throws GeoIpException {
		if (geoIpUtil == null)
			geoIpUtil = new GeoIpUtil();
	}

	public IpAddressDaoImpl(EntityManager entityManager) throws GeoIpException {
		this();
		this.entityManager = entityManager;
	}

	@Override
	public Long countAll(Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.countAll());
		return (Long) query.getSingleResult();
	}

	@Override
	public Long countStatusIp(boolean status, Class<? extends IpAddress> ipType)
			throws DBException {
		Query query = entityManager.createNamedQuery(
				createIpAddress(ipType).countStatusList()).setParameter(1,
				status);
		return (Long) query.getSingleResult();
	}

	@Override
	public Long countStatusIpByCityName(boolean status, String cityName,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.countStatusIpByCityName());
		query = query.setParameter(1, status).setParameter(2, cityName);
		return (Long) query.getSingleResult();
	}

	@Override
	public Long countStatusIpByCountryName(boolean status, String countryName,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.countStatusIpByCountryName());
		query = query.setParameter(1, status).setParameter(2, countryName);
		return (Long) query.getSingleResult();
	}

	@Override
	public Long countStatusIpByCountryCode(boolean status, String countryCode,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.countStatusIpByCountryCode());
		query = query.setParameter(1, status).setParameter(2, countryCode);
		return (Long) query.getSingleResult();
	}

	@Override
	public void deleteIp(IpAddress address) {
		entityManager.remove(address);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IpAddress> T findByAddress(String address,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(
				createIpAddress(ipType).findByAddress()).setParameter(1,
				address);
		return (T) find(query);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IpAddress> List<T> findIpListBySource(int sourceId,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.findIpListBySource());
		query.setParameter(1, sourceId);
		return query.getResultList();
	}

	@Override
	public <T extends IpAddress> List<T> findStatusList(boolean status,
			int from, int count, Class<? extends IpAddress> ipType)
			throws DBException {
		Query query = entityManager.createNamedQuery(
				createIpAddress(ipType).findStatusList()).setParameter(1,
				status);
		return findRange(from, count, query);
	}

	@Override
	public <T extends IpAddress> List<T> findStatusListByCity(boolean status,
			int from, int count, String cityName,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.findStatusListByCity());
		query = query.setParameter(1, status).setParameter(2, cityName);
		return findRange(from, count, query);
	}

	@Override
	public <T extends IpAddress> List<T> findStatusListByCountryName(
			boolean status, int from, int count, String countryName,
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.findStatusListByCountryName());
		query = query.setParameter(1, status).setParameter(2, countryName);
		return findRange(from, count, query);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends IpAddress> List<T> findUndefList(
			Class<? extends IpAddress> ipType) throws DBException {
		Query query = entityManager.createNamedQuery(createIpAddress(ipType)
				.findUndefinedList());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	private <T extends IpAddress> T createIpAddress(
			Class<? extends IpAddress> ipType) throws DBException {
		try {
			return (T) ipType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new DBException("New Instantiation Exception", e);
		}
	}

	@Override
	public void removeIpFromStatusList(boolean status, IpAddress address) {
		address.setStatus(status);
		entityManager.persist(address);
	}

	@Override
	public void save(IpAddress address) {
		address.setModified(true);
		entityManager.persist(address);
		IpAddress.IP_MAP.put(address.getAddress(), address);
	}

	@Override
	public IpAddress update(IpAddress address) {
		// address.setModified(true);
		address = entityManager.merge(address);
		IpAddress.IP_MAP.put(address.getAddress(), address);
		return address;
	}

	// @Override
	// public void saveList(List<? extends IpAddress> list, int sourceId,
	// Class<? extends IpAddress> ipType,
	// Map<String, IpAddress> map) throws DBException, GeoIpException {
	// Source source = entityManager.find(Source.class, sourceId);
	// // Source source = sourceDao.findByID(sourceId);
	// if (source == null) {
	// throw new DBException("Didn't find source with id " + sourceId);
	// } else {
	// int persist = 0;
	// int merge = 0;
	// int notModified = 0;
	// for (IpAddress ip : list) {
	// if (!map.containsKey(ip.getAddress()) && ip != null) {
	// ip.getSourceSet().add(source);
	// ipCountry(ip);
	// save(ip);
	// // ipDao.save(ip);
	// persist++;
	// } else {
	// IpAddress temp = map.get(ip.getAddress());
	// if (temp.getSourceSet().add(source)) {
	// update(temp);
	// // ipDao.update(temp);
	// merge++;
	// } else {
	// notModified++;
	// }
	// }
	// }
	// LOGGER.info("persist operations: " + persist + ", merge operations: " +
	// merge + ", not modified: "
	// + notModified);
	// }
	// }
	//
	// private void ipCountry(IpAddress ip) throws GeoIpException {
	// // if (ipAddress == null) {
	// // LOGGER.info("setLocation(IpAddress ipAddress) has null as parameter");
	// // return;
	// // }
	//
	// City city = getLocation(ip);
	// Country country = city.getCountry();
	// if (!Country.COUNTRY_MAP.containsKey(country.getCountryName())) {
	// // if (!countryDao.isCountryExists(country)) {
	// entityManager.persist(country);
	// // countryDao.save(country);
	// entityManager.persist(city);
	// // cityDao.save(city);
	// } else {
	// Country tempCountry = Country.COUNTRY_MAP.get(country.getCountryName());
	// // Country tempCountry =
	// // Country.COUNTRY_MAP.get(country.getCountryName());
	// if (!City.CITY_MAP.containsKey(city.getCityName())) {
	// // if (!cityDao.isCityExists(city)) {
	// city.setCountry(tempCountry);
	// entityManager.merge(tempCountry);
	// // countryDao.update(tempCountry);
	// entityManager.persist(city);
	// // cityDao.save(city);
	// } else {
	// city = City.CITY_MAP.get(city.getCityName());
	// ip.setCity(city);
	// entityManager.merge(city);
	// // cityDao.update(city);
	// entityManager.merge(tempCountry);
	// // countryDao.update(tempCountry);
	// }
	// }
	// }
	//
	// private City getLocation(IpAddress ip) throws GeoIpException {
	// geoIpUtil.addCityToIpAddress(ip);
	//
	// City city = ip.getCity();
	// if (city.getCityName() == null)
	// city.setCityName("UNKNOWN");
	//
	// Country country = city.getCountry();
	// if (country.getCountryName() == null)
	// country.setCountryName("UNKNOWN");
	// return city;
	// }

	@Override
	@SuppressWarnings("unchecked")
	public void creatIpMap() {
		if (!IpAddress.IS_MAP_CREATE) {
			Query query = entityManager
					.createNamedQuery(IpAddress.FIND_ALL_VALID);
			List<IpAddress> listFromDB = query.getResultList();
			for (IpAddress ip : listFromDB) {
				ip.setModified(false);
				IpAddress.IP_MAP.put(ip.getAddress(), ip);
			}
			IpAddress.IS_MAP_CREATE = true;
		}
	}
	//
	// @Override
	// public void updateStatusList(Map<String, IpAddress> map) throws
	// DBException {
	// int merge = 0;
	// int notModified = 0;
	// Iterator<String> it = map.keySet().iterator();
	// IpAddress ip;
	// while (it.hasNext()) {
	// ip = map.get(it.next());
	// if (calculateRank(ip)) {
	// // ipDao.update(ip);
	// entityManager.merge(ip);
	// merge++;
	// } else {
	// notModified++;
	// }
	// }
	// LOGGER.info("merge operations: " + merge + ", not modified: " +
	// notModified);
	// }
	//
	// private boolean calculateRank(IpAddress ip) throws DBException {
	// if (ip == null || ip.getModified() == null) {
	// return false;
	// }
	// Set<Source> sourceSet = ip.getSourceSet();
	// if (sourceSet.size() != 0 && ip.getModified()) {
	// // return false;
	// // }
	// // if (ip.getModified()) {
	// Iterator<Source> it = sourceSet.iterator();
	// ip.setStatus(rankLogick(it) > 0);
	// ip.setModified(false);
	// return true;
	// }
	// return false;
	// }
	//
	// private double rankLogick(Iterator<Source> it) throws DBException {
	// double statuskRank = 0;
	// while (it.hasNext()) {
	// Source source = it.next();
	// if (source.getListType().equals(Source.WHITE_LIST)) {
	// statuskRank += source.getRank();
	// } else if (source.getListType().equals(Source.BLACK_LIST)) {
	// statuskRank -= source.getRank();
	// } else {
	// throw new DBException(source.getListType() +
	// " didn't supported by updateStatusList() method");
	// }
	// }
	// return statuskRank;
	// }
}
