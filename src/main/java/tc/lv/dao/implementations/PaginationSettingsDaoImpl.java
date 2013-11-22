package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.PaginationSettingsDao;
import tc.lv.domain.PaginationSettings;

@Repository
public class PaginationSettingsDaoImpl extends DaoAbstract implements PaginationSettingsDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<PaginationSettings> findAll() {
        Query query = entityManager.createNamedQuery(PaginationSettings.FIND_ALL);
        return query.getResultList();
    }
}
