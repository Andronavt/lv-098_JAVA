package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.dao.UserDaoImpl;
import tc.lv.domain.UserEntity;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao dao = new UserDaoImpl();
	@Autowired
	private Assembler assembler;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserDetails userDetails = null;
		UserEntity userEntity = dao.getUserByName(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("user not found");
		}
		userDetails = assembler.buildUserFromUserEntity(userEntity);	
		return userDetails;
	}
}