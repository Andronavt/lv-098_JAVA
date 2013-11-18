package tc.lv.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.dao.Dao;
import tc.lv.dao.UndefinedListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

@Repository
public class UndefinedListDaoImpl extends Dao implements UndefinedListDao {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public List<IpV4Address> getIpV4List() {
        return entityManager.createNamedQuery(IpV4Address.FIND_UNDEFINEDLIST, IpV4Address.class).getResultList();
    }

    @Override
    public List<IpV6Address> getIpV6List() {
        return entityManager.createNamedQuery(IpV6Address.FIND_UNDEFINEDLIST, IpV6Address.class).getResultList();
    }

}
