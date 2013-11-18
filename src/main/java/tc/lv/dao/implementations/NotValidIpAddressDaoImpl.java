package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.dao.Dao;
import tc.lv.dao.NotValidIpAddressDao;
import tc.lv.domain.NotValidIp;

@Repository
public class NotValidIpAddressDaoImpl extends Dao implements NotValidIpAddressDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<NotValidIp> getListBySource(int sourceId) {
        Query query = entityManager.createNamedQuery(NotValidIp.FIND_BY_SOURCE);
        return query.setParameter(1, sourceId).getResultList();
    }
}
