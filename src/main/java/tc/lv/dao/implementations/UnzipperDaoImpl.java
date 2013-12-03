package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.UnzipperDao;
import tc.lv.domain.Unzipper;

@Repository
public class UnzipperDaoImpl extends DaoAbstract implements UnzipperDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<Unzipper> findAll() {
        return null;
    }

    @Override
    public String findUrlByName(String name) {
        return null;
    }
}
