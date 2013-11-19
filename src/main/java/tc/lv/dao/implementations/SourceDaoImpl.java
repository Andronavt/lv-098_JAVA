package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.DaoAbstract;
import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;

@Repository
public class SourceDaoImpl extends DaoAbstract implements SourceDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public Source findByName(String sourceName) {
        Query query = entityManager.createNamedQuery(Source.FIND_BY_NAME).setParameter(1, sourceName);
        return (Source) find(query);
    }

    @Override
    public List<Source> findAll() {
        return entityManager.createNamedQuery(Source.FIND_ALL, Source.class).getResultList();
    }

    @Override
    public void save(Source source) {
        entityManager.persist(source);
    }

    @Override
    public Source update(Source source) {
        return entityManager.merge(source);
    }

    @Override
    public void delete(Source source) {
        entityManager.remove(source);
    }
}
