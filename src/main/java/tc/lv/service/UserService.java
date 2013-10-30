package tc.lv.service;

import tc.lv.domain.UserDB;

public interface UserService {
	public UserDB getUserByName(String name);
}
