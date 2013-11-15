package tc.lv.dao;

import tc.lv.domain.Role;
import tc.lv.domain.User;

public interface UserDao {

    User findByName(String name);

    void save(User user);

    Role findRoleByName(String roleName);

    void remove(User user);

    User update(User user);

}
