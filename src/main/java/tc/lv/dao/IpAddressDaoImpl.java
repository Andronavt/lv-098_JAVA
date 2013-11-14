package tc.lv.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import tc.lv.domain.IpAddress;
import tc.lv.domain.NotValidIp;

@Repository
public class IpAddressDaoImpl implements IpAddressDao {

	private static final Logger loggerInfo = Logger.getLogger("infoLog");

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public List<IpAddress> getListBySource(int sourceId,
			Class<? extends IpAddress> userClass) {
		Query query = entityManager.createNamedQuery(userClass.getSimpleName()
				+ ".getBySource");
		query.setParameter("id", sourceId);
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}

	@Deprecated
	@Override
	public List<IpAddress> getWhiteList(int from, int count,
			Class<? extends IpAddress> userClass) {
		Query query = entityManager
				.createNamedQuery(userClass.getSimpleName() + ".getWhiteList")
				.setParameter("whitelist", true).setFirstResult(from)
				.setMaxResults(count);
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}

	@Deprecated
	@Override
	public List<IpAddress> getWhiteList(Class<? extends IpAddress> userClass) {
		Query query = entityManager.createNamedQuery(
				userClass.getSimpleName() + ".getWhiteList").setParameter(
				"whitelist", true);
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}

	@Override
	public IpAddress findByAddress(String address) {
		Query query = entityManager.createNamedQuery("IpAddress.findByAddress")
				.setParameter("address", address);
		try {
			IpAddress object = (IpAddress) query.getSingleResult();
			return object;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void save(IpAddress address) {
		entityManager.persist(address);

	}

	@Override
	public boolean removeFromWhiteList(IpAddress address) {
		if (address.getClass().isAssignableFrom(NotValidIp.class)) {
			return false;
		} else {
			address.setWhiteList(false);
			entityManager.persist(address);
			return true;
		}
	}

	@Deprecated
	@Override
	public List<IpAddress> getBlackList(int from, int count) {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList")
				.setParameter("whitelist", false).setFirstResult(from)
				.setMaxResults(count);
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}

	@Deprecated
	@Override
	public List<IpAddress> getBlackList() {
		Query query = entityManager
				.createNamedQuery("IpV4Address.getWhiteList").setParameter(
						"whitelist", false);
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}

	@Override
	public boolean removeFromBlackList(IpAddress address) {
		if (address.getClass().isAssignableFrom(NotValidIp.class)) {
			return false;
		} else {
			address.setWhiteList(true);
			entityManager.persist(address);
			return true;
		}
	}

	@Override
	public Collection<IpAddress> getUnDefList(
			Class<? extends IpAddress> userClass) {
		Query query = entityManager.createNamedQuery(userClass.getSimpleName()
				+ ".getUndefinedList");
		@SuppressWarnings("unchecked")
		List<IpAddress> list = query.getResultList();
		return list;
	}
}
