package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.CountryDao;
import tc.lv.dao.DaoAbstract;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.DBException;

@Repository
public class CountryDaoImpl extends DaoAbstract implements CountryDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public CountryDaoImpl() {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountryCodeListByStatus(boolean status, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_CODE_LIST_BY_STATUS);
        query = query.setParameter(1, status);
        return query.getResultList();
    }

    @Override
    public String findCountryCodeByCountryName(String country, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_CODE_BY_COUNTRY_NAME);
        query = query.setParameter(1, country);
        return (String) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findCountryNameListByStatus(boolean status, Class<? extends IpAddress> ipType)
            throws DBException {
        Query query = entityManager.createNamedQuery(Country.FIND_COUNTRY_NAME_LIST_BY_STATUS);
        query = query.setParameter(1, status);
        return query.getResultList();
    }
}
