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

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCityNameListByStatus(boolean status) throws DBException {
        Query query = entityManager.createNamedQuery(City.FIND_CITY_NAME_LIST_BY_STATUS);
        query = query.setParameter(1, status);
        return query.getResultList();
    }
}
