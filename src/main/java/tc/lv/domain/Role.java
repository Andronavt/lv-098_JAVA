package tc.lv.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@Column(name = "role_id", nullable = false)
	private int id;
	@Column(name = "role", nullable = false)
	private String role;
	
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy="roleSet",fetch=FetchType.EAGER)
	private Set<UserEntity> userSet = new HashSet<UserEntity>();

	public Role() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
