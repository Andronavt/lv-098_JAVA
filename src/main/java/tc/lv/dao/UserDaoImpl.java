package tc.lv.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	@Override
	public UserEntity getUserByName(String name) {
		UserEntity foundUser = entityManager
				.createNamedQuery("UserEntity.findByName", UserEntity.class)
				.setParameter("username", name).getSingleResult();

		return foundUser;
	}

	@Override
	public void addAdminUser(String username, String firstname,
			String lastname, String email, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password) {
		int idCustomerUser = 2;
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		Set<Role> roleSet = new HashSet<Role>();
		Role role = new Role();
		role = entityManager.find(Role.class, idCustomerUser);
		roleSet.add(role);
		user.setRoleSet(roleSet);
		entityManager.persist(user);
	}
}
