package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.UserE;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao dao;
    @Autowired
    private Assembler assembler;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException, DataAccessException {

	UserDetails userDetails = null;
	//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + userDetails);
	UserE userEntity = dao.getUserByName(username);
	
	if (userEntity == null)
	    throw new UsernameNotFoundException("user not found");

	return assembler.buildUserFromUserEntity(userEntity);
    }
}