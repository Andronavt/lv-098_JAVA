//package tc.lv.domain.test;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.IndexColumn;
//
//@Entity
//@Table(name = "ipv4_addresses")
//public class IpV4Address extends IpAddress implements Serializable {
//	
//	@ManyToMany(cascade= CascadeType.MERGE,mappedBy="ipv4Set")
//	private Set<Source> sourceSet = new HashSet<Source>();
//	
//	public Set<Source> getSourceSet() {
//		return sourceSet;
//	}
//
//	public void setSourceSet(Set<Source> sourceSet) {
//		this.sourceSet = sourceSet;
//	}
//	
//	public void addElementToSourceSet(Source source){
//		sourceSet.add(source);
//	}
//
//	public IpV4Address() {
//
//	}
//
//	public IpV4Address(String address) {
//		this.address = address;
//	}
//
//}
