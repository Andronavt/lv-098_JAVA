package tc.lv.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;

public abstract class Dao {
    Map<Class<? extends IpAddress>, Map<String, String>> map = new TreeMap<>();

    void generetMap() {
        Map<String, String> ipv4Map = new TreeMap<>();
        ipv4Map.put("FIND_ALL", IpV4Address.FIND_ALL);
        map.put(IpV4Address.class, ipv4Map);
    }

    public Object find(Query query) {
        map.get(IpV4Address.class).get("FIND_ALL");
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
