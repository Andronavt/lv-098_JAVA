package tc.lv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tc.lv.domain.User;
import tc.lv.domain.UserSecurity;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	public Map<String, UserSecurity> getUserMap() {
		List<User> tempUserList = entityManager.createQuery("from User").getResultList();
		Map<String, UserSecurity> tempUserMap = new HashMap<String, UserSecurity>();
		for(User temp : tempUserList){
			tempUserMap.put(temp.getUsername(), new UserSecurity(temp));
		}
		System.out.println(tempUserMap.toString()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return tempUserMap;
	}

	@Override
	public User getUserByName(String name) {
		User foundUser = entityManager
				.createNamedQuery("UserDB.findByName", User.class)
				.setParameter("name", name).getSingleResult();
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
