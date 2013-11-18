package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;

@Repository
public class SourceDaoImpl extends Dao implements SourceDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    @Override
    public Source findByName(String sourceName) {
        Query query = entityManager.createNamedQuery(Source.FIND_BY_NAME).setParameter(1, sourceName);
        return (Source) find(query);
    }

    @Override
    public List<Source> getAll() {
        return entityManager.createNamedQuery(Source.GET_ALL, Source.class).getResultList();
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
        // deleteSourceWithoutIp(source);
        deleteSourceWithIp(source);
    }

    // deleteSourceWithIp
    public void deleteSourceWithIp(Source source) {
        for (IpAddress ip : source.getIpSet()) {

            ip.getSourceSet().remove(source);

            if (ip.getSourceSet().size() == 0) {
                entityManager.remove(ip);
            }
        }
        source.getIpSet().clear();

        entityManager.remove(source);
    }

    // deleteSourceWithoutIp
    public void deleteSourceWithoutIp(Source source) {
        entityManager.createNamedQuery(Source.DELETE).setParameter(1, source.getSourceName()).executeUpdate();
       
    }
}
