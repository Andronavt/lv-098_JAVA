package tc.lv.service.implementation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class AssemblerTest {
    @Autowired
    private Assembler assembler;

    @Test
    public void loadUserByUsernameTestSeccess() {
	UserDetails userDetails = assembler.buildUserFromUserEntity(new User(
		"admin", "admin", "admin", "admin@gmail.com", "admin"));
	Assert.assertEquals("admin", userDetails.getUsername());
    }

}
