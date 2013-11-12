package tc.lv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.IpV4Address;

@Repository
public class IpV4AddressDaoImpl implements IpV4AddressDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    @Override
    public List<IpV4Address> loadAll(int sourceId) {
	List<IpV4Address> list = new ArrayList<IpV4Address>();
	Query q = entityManager.createNamedQuery("IpV4Address.loadBySource")
		.setParameter("id", sourceId);
	list.addAll(q.getResultList());
	return list;
    }
}
