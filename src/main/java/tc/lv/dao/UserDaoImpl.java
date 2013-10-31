package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	@Override
	public User getUserByName(String name) {
		User foundUser = entityManager.createNamedQuery("UserDB.findByName", User.class).setParameter("name", name).getSingleResult();
		return foundUser;
	}

	@Override
	public void addAdminUser(String name, String password) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void addCustomerUser(String name, String password) {
		// TODO Auto-generated method stub		
	}

}
