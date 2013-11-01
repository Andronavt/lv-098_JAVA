package tc.lv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import tc.lv.domain.UserEntity;


@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	public UserDaoImpl() {

	}


	@Override
	public UserEntity getUserByName(String name) {
		UserEntity foundUser = entityManager.createNamedQuery("UserEntity.findByName", UserEntity.class).setParameter("username", name).getSingleResult();

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
