package tc.lv.dao;

import tc.lv.domain.UserEntity;

public interface UserDao {

	UserEntity findByName(String name);

	void save(UserEntity user);

}
