package tc.lv.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public abstract class DaoAbstract {
    public static final String PERSISTENCE_UNIT_NAME = "primary";

    public static Object find(Query query) {
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> findRange(int from, int count, Query query) {
        query = query.setFirstResult(from).setMaxResults(count);
        return query.getResultList();
    }

}
