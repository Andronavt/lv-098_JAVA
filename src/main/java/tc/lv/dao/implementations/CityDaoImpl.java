package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.CityDao;
import tc.lv.dao.DaoAbstract;
import tc.lv.domain.City;
import tc.lv.exceptions.DBException;

@Repository
public class CityDaoImpl extends DaoAbstract implements CityDao {

	@PersistenceContext(name = PERSISTENCE_UNIT_NAME)
	private EntityManager entityManager;

	public CityDaoImpl() {

	}

	public CityDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> findCityNameListByStatus(boolean status)
			throws DBException {
		Query query = entityManager
				.createNamedQuery(City.FIND_CITY_NAME_LIST_BY_STATUS);
		query = query.setParameter(1, status);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void creatCityMap() {
		if (!City.IS_MAP_CREATE) {
			Query query = entityManager.createNamedQuery(City.FIND_ALL);
			List<City> listFromDB = query.getResultList();
			for (City ci : listFromDB) {
				City.CITY_MAP.put(ci.getCityName(), ci);
			}
			City.IS_MAP_CREATE = true;
		}
	}

	@Override
	public void save(City city) {
		entityManager.persist(city);
	}

	@Override
	public City update(City city) {
		return entityManager.merge(city);
	}

	@Override
	public boolean isCityExists(City city) {
		return City.CITY_MAP.containsKey(city.getCityName());
	}
}
