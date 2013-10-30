package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.UserDB;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	@Override
	public UserDB getUserByName(String name) {
		UserDB foundUser = entityManager.createNamedQuery("UserDB.findByName", UserDB.class).setParameter("name", name).getSingleResult();
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
