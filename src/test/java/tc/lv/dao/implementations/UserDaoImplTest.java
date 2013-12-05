package tc.lv.dao.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		user = new User("niger", "niger", "niger", "niger@gmail.com", "niger");
		newUser = new User("white", "niger", "niger", "niger@gmail.com",
				"niger");
		role = new Role();
		role.setRole("ROLE_ADMIN");
	}

	@Test
	public void saveUser() {
		if (user.equals(userDao.findByName("niger"))) {
			fail("USER ALREADY EXIST");
		}
		userDao.save(user);
		assertEquals(user, userDao.findByName("niger"));
	}

	@Test
	public void removeUser() {
		saveUser();
		userDao.remove(user);
		assertEquals(null, userDao.findByName("niger"));
	}

	@Test
	public void findUserByName() {
		saveUser();
		assertEquals(user, userDao.findByName("niger"));
	}

	@Test
	public void findUserByRole() {
		saveUser();
		assertEquals(role.getRole(), userDao.findRoleByName("ROLE_ADMIN")
				.getRole());
	}

	@Test
	public void updateUser() {
		saveUser();
		userDao.update(newUser);
		assertEquals(newUser, userDao.findByName("white"));		
	}

}
