package tc.lv.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import tc.lv.domain.IpAddress;

public abstract class Dao {

    public Object find(Query query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<? extends IpAddress> getRange(int from, int count, Query query) {
        query = query.setFirstResult(from).setMaxResults(count);
        return query.getResultList();
    }
}
