package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public UserEntity findByName(String name) {

		Query query = entityManager.createNamedQuery(UserEntity.FIND_BY_NAME)
				.setParameter(1, name);
		return (UserEntity) Dao.find(query);
	}

	@Override
	public Role findRoleByName(String roleName) {

		Query query = entityManager.createNamedQuery(Role.FIND_BY_NAME)
				.setParameter(1, roleName);
		return (Role) Dao.find(query);
	}

	@Override
	public void remove(UserEntity user) {

		user.getRoleSet().clear();
		entityManager.remove(user);
	}

	@Override
	public void save(UserEntity user) {

		entityManager.persist(user);
	}
}
