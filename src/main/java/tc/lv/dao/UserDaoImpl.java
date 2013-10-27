package tc.lv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
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
		User foundUser = entityManager.createNamedQuery("User.findByName", User.class).setParameter("name", name).getSingleResult();
		return foundUser;
	}

	@Override
	public boolean addAdminUser(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomerUser(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		User a= dao.getUserByName("admin");
		System.out.println(a.getName());
	}

}
