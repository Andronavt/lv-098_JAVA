package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Role;
import tc.lv.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public User findByName(String name) {

		Query query = entityManager.createNamedQuery(User.FIND_BY_NAME)
				.setParameter(1, name);
		return (User) Dao.find(query);
	}

	@Override
	public Role findRoleByName(String roleName) {

		Query query = entityManager.createNamedQuery(Role.FIND_BY_NAME)
				.setParameter(1, roleName);
		return (Role) Dao.find(query);
	}

	@Override
	public void remove(User user) {

		user.getRoleSet().clear();
		entityManager.remove(user);
	}

	@Override
	public void save(User user) {

		entityManager.persist(user);
	}

	@Override
	public User update(User user) {

		return entityManager.merge(user);
	}
}
