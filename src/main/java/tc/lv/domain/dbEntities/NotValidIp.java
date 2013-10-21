package tc.lv.domain.dbEntities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "not_valid_ip")
public class NotValidIp extends IpAddress {
	
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "notValidSet")
	private Set<Source> sourceSet = new HashSet<Source>();
	
	public NotValidIp() {

	}
	
	public NotValidIp(String address) {
		this.address = address;
	}
	
	public NotValidIp(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}

	public Set<Source> getSourceSet() {
		return sourceSet;
	}

	public void setSourceSet(Set<Source> sourceSet) {
		this.sourceSet = sourceSet;
	}

	public void addElementToSourceSet(Source source) {
		sourceSet.add(source);
	}
	
}
