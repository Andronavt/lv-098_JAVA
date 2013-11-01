package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.UserE;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	@Override
	public UserE getUserByName(String name) {
		UserE foundUser = entityManager.createNamedQuery("User.findByName", UserE.class).setParameter("username", name).getSingleResult();
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
