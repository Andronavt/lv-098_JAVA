package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public UserEntity findByName(String name) {
		Query query = entityManager.createNamedQuery("UserEntity.loadByName",
				UserEntity.class).setParameter("username", name);
		UserEntity foundUser;
		try {
			foundUser = (UserEntity) query.getSingleResult();
			return foundUser;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void save(UserEntity user) {
		entityManager.persist(user);
	}

}
