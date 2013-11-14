package tc.lv.dao;

import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;

public interface UserDao {

	UserEntity findByName(String name);

	Role findRoleByName(String roleName);

	void remove(UserEntity user);

	void save(UserEntity user);

}
