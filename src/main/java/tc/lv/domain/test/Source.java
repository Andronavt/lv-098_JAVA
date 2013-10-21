//package tc.lv.domain.test;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Persistence;
//import javax.persistence.PostLoad;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
//import org.junit.Ignore;
//
//@Entity
//@Table(name = "sources")
//public class Source implements Serializable {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "source_id")
//	private int sourceId;
//
//	@Column(name = "source_name")
//	private String sourceName;
//
//	@ManyToMany(cascade =CascadeType.ALL)
//	@JoinTable(name = "source_to_addresses", 
//	joinColumns = {@JoinColumn(name = "source_id")}, 
//	inverseJoinColumns = {@JoinColumn(name = "v4_id",updatable=true)})
//	@Fetch(FetchMode.JOIN)
//	private  Set<IpV4Address> ipv4Set = new HashSet<IpV4Address>();
//
//
//	public Set<IpV4Address> getIpv4Set() {
//		return ipv4Set;
//	}
//
//	public void setIpv4Set(Set<IpV4Address> ipv4Set) {
//		this.ipv4Set = ipv4Set;
//	}
//
//	public Source(){
//		
//	}
//	
//	public void addElementToSetV4(IpV4Address a){
//		ipv4Set.add(a);
//	}
//	
//	public Source(String sourceName) {
//		super();
//		this.sourceName = sourceName;
//	}
//
//	public int getSourceId() {
//		return sourceId;
//	}
//
//	public void setSourceId(int sourceId) {
//		this.sourceId = sourceId;
//	}
//
//	public String getSourceName() {
//		return sourceName;
//	}
//
//	public void setSourceName(String sourceName) {
//		this.sourceName = sourceName;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((sourceName == null) ? 0 : sourceName.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Source other = (Source) obj;
//		if (sourceName == null) {
//			if (other.sourceName != null)
//				return false;
//		} else if (!sourceName.equals(other.sourceName))
//			return false;
//		return true;
//	}
//
//}
