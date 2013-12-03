package tc.lv.service.implementation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.exceptions.UserEntityServiceException;
import tc.lv.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserTestSuccess() throws UserEntityServiceException {
	boolean actual = userService.createUser("testUser2", "john", "smith",
		"smith@gmail.com", "1234");
	Assert.assertTrue(actual);
    }

    @Test
    public void createUserTestFail() throws UserEntityServiceException {
	boolean actual = userService.createUser("admin", "john", "smith",
		"smith@gmail.com", "1234");
	Assert.assertFalse(actual);
    }

    @Test
    public void makeUserAdminByNameTestSuccess()
	    throws UserEntityServiceException {
	boolean actual = userService.makeUserAdminByName("user");
	Assert.assertTrue(actual);
    }

    @Test
    public void makeUserAdminByNameTestFail() throws UserEntityServiceException {
	boolean actual = userService.makeUserAdminByName("unExistUser");
	Assert.assertFalse(actual);
    }

}
