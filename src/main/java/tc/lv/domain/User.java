package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "users")
@NamedQuery(name = User.FIND_BY_NAME, query = User.FIND_BY_NAME_QUERY)
public class User {

    public static final String FIND_BY_NAME = "User.findByName";
    public static final String FIND_BY_NAME_QUERY = "SELECT u FROM User u WHERE u.username = ?1";

    @Column(name = "ctime", nullable = true)
    private Date ctime;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "firstname", nullable = true)
    private String firstname;

    @Column(name = "lastname", nullable = true)
    private String lastname;

    @Column(name = "ltime", nullable = true)
    private Date ltime;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "role_id", updatable = true, nullable = true) })
    @Fetch(FetchMode.JOIN)
    private Set<Role> roleSet = new HashSet<Role>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    public User() {

    }

    public User(String username, String email, String password, Set<Role> roleSet) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleSet = roleSet;
    }

    public User(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void addRoleToUser(Role role) {
        getRoleSet().add(role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    public Date getCtime() {
        return ctime;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getLtime() {
        return ltime;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    public void removeRoleFromUser(Role role) {
        getRoleSet().remove(role);
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLtime(Date ltime) {
        this.ltime = ltime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
