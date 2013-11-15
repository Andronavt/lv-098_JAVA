package tc.lv.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NamedQuery(name = Role.FIND_BY_NAME, query = Role.FIND_BY_NAME_QUERY)
public class Role {

    public static final String FIND_BY_NAME = "Role.findByName";
    public static final String FIND_BY_NAME_QUERY = "SELECT r FROM Role r WHERE r.role = ?1";

    @Id
    @Column(name = "role_id", nullable = false)
    private int id;

    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.EAGER)
    private Set<User> userSet = new HashSet<User>();

    public Role() {

    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
