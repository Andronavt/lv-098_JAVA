package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.UnzipperDao;
import tc.lv.domain.Unzipper;

@Repository
public class UnzipperDaoImpl extends DaoAbstract implements UnzipperDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Unzipper> findAll() {
        Query query = entityManager.createNamedQuery(Unzipper.FIND_ALL);
        return query.getResultList();
    }

    @Override
    public String findDirByName(String name) {
        Query query = entityManager.createNamedQuery(Unzipper.FIND_DIR_BY_NAME);
        return (String) find(query);
    }
}
