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
@NamedQuery(name = "UserDB.findByName", query = "SELECT c FROM User c WHERE c.username = :username")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int userId;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "firstname", nullable = true)
    private String firstname;
    @Column(name = "lastname", nullable = true)
    private String lastname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "ctime", nullable = true)
    private Date ctime;
    @Column(name = "ltime", nullable = true)
    private Date ltime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "role_id", updatable = true, nullable = true) })
    @Fetch(FetchMode.JOIN)
    private Set<Role> roleSet = new HashSet<Role>();

    public User() {

    }

    public User(String username, String email, String password,
	    Set<Role> roleSet) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.roleSet = roleSet;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getCtime() {
	return ctime;
    }

    public void setCtime(Date ctime) {
	this.ctime = ctime;
    }

    public Date getLtime() {
	return ltime;
    }

    public void setLtime(Date ltime) {
	this.ltime = ltime;
    }

    public Set<Role> getRoleSet() {
	return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
	this.roleSet = roleSet;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((password == null) ? 0 : password.hashCode());
	return result;
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

}
