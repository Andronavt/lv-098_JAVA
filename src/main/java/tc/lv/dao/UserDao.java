package tc.lv.dao;

import tc.lv.domain.UserEntity;
import tc.lv.exceptions.DBCreateUserException;

public interface UserDao {

    UserEntity loadByName(String name);

    public void createUser(UserEntity user) throws DBCreateUserException;
    
    public void makeUserAdmin(UserEntity user);

}
