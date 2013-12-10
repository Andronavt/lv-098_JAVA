package tc.lv.dao.implementations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.Role;
import tc.lv.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class UserDaoImplTest {

	@Autowired
	protected UserDao userDao;

	protected User user;

	protected User newUser;

	protected Role role;

	@Before
	public void dataSetup() {
		user = new User("test", "test", "test", "test@gmail.com", "test");
		userDao.save(user);
	}

	@Test
	public void saveUser() {
		userDao.save(user);
		User expected = user;
		assertEquals(expected, userDao.findByName("test"));
	}

	@Test
	public void removeUser() {
		userDao.remove(user);
		assertEquals(null, userDao.findByName("test"));
	}

	@Test
	public void findUserByName() {
		User expected = user;
		User actuals = userDao.findByName("test");
		assertEquals(expected, actuals);
	}

	@Test
	public void findUserByRoleAdmin() {
		role = new Role();
		role.setRole("ROLE_ADMIN");
		String expected = role.getRole();
		String actuals = userDao.findRoleByName("ROLE_ADMIN").getRole();
		assertEquals(expected, actuals);
	}
	
	@Test
	public void findUserByRoleUser() {
		role = new Role();
		role.setRole("ROLE_USER");
		String expected = role.getRole();
		String actuals = userDao.findRoleByName("ROLE_USER").getRole();
		assertEquals(expected, actuals);
	}

	@Test
	public void updateUser() {
		newUser = new User("newTest", "test", "test", "test@gmail.com", "test");
		userDao.update(newUser);
		User expected = newUser;
		User actuals = userDao.findByName("newTest");
		assertEquals(expected, actuals);
	}

}
