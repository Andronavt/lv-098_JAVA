package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.CountryDao;
import tc.lv.dao.DaoAbstract;
import tc.lv.domain.Country;
import tc.lv.exceptions.DBException;

@Repository
public class CountryDaoImpl extends DaoAbstract implements CountryDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public CountryDaoImpl() {

    }

    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountryCodeListByStatus(boolean status) throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_CODE_LIST_BY_STATUS);
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    public String findCountryCodeByCountryName(String country) throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_CODE_BY_COUNTRY_NAME);
        query = query.setParameter(1, country);
        return (String) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountryNameListByStatus(boolean status) throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_NAME_LIST_BY_STATUS);
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void creatCountryMap() {
        if (!Country.IS_MAP_CREATE) {
            Query query = entityManager.createNamedQuery(Country.FIND_ALL);
            List<Country> listFromDB = query.getResultList();
            for (Country co : listFromDB) {
                Country.COUNTRY_MAP.put(co.getCountryName(), co);
            }
            Country.IS_MAP_CREATE = true;
        }
    }

    @Override
    public void save(Country country) {
        entityManager.persist(country);
    }

    @Override
    public Country update(Country country) {
        return entityManager.merge(country);
    }

    @Override
    public boolean isCountryExists(Country country) {
        return Country.COUNTRY_MAP.containsKey(country.getCountryName());
    }
}
