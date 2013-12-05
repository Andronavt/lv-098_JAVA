package tc.lv.service.implementation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class UserDetailServiceTest {
    @Autowired
    UserDetailsService userDetailsService;

    @Test
    public void loadUserByUsernameTestSuccess() {
	UserDetails userDetails = userDetailsService
		.loadUserByUsername("admin");
	Assert.assertEquals("admin", userDetails.getUsername());
    }

}
