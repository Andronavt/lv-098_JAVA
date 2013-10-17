package tc.lv.domain.ipClasses;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "sources")
public class Source {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "source_id")
	private int sourceId;

	@Column(name = "source_name")
	private String sourceName;

	@Column(name = "url")
	private String url;

	@Column(name = "source_date_added")
	private Date source_date_added;

	@Column(name = "updated")
	private Date updated;

	@Column(name = "rank")
	private double rank;

	@Column(name = "dirname")
	private String dirname;

	@Column(name = "list_type")
	private String list_type;

	@Column(name = "adaptor")
	private String adaptor;

	@Column(name = "downloader")
	private String downloader;

	@Column(name = "md5")
	private String md5;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = {@JoinColumn(name = "source_id")}, 
	                                         inverseJoinColumns = {@JoinColumn(name = "v4_id")})
	private Collection<IpV4Address> ipv4Set = new HashSet<IpV4Address>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = {@JoinColumn(name = "source_id")}, 
	                                         inverseJoinColumns = {@JoinColumn(name = "v6_id")})
	private Collection<IpV6Address> ipv6Set = new HashSet<IpV6Address>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = {@JoinColumn(name = "source_id")}, 
	                                         inverseJoinColumns = {@JoinColumn(name = "not_valid")})
	private Collection<NotValidIp> notValidSet = new HashSet<NotValidIp>();

	public Collection<NotValidIp> getNotValidSet() {
		return notValidSet;
	}
	public void setNotValidSet(Collection<NotValidIp> notValidSet) {
		this.notValidSet = notValidSet;
	}
	public Source(){
		
	}
	public Source(String sourceName, String url, Date source_date_added,
			Date updated, double rank, String dirname, String list_type,
			String adaptor, String downloader, String md5,
			Collection<IpV4Address> ipv4Set) {
		super();
		this.sourceName = sourceName;
		this.url = url;
		this.source_date_added = source_date_added;
		this.updated = updated;
		this.rank = rank;
		this.dirname = dirname;
		this.list_type = list_type;
		this.adaptor = adaptor;
		this.downloader = downloader;
		this.md5 = md5;
		this.ipv4Set = ipv4Set;
	}
	public Source(String sourceName, String url, Date source_date_added,
			Date updated, double rank, String dirname, String list_type,
			String adaptor, String downloader, String md5) {
		super();
		this.sourceName = sourceName;
		this.url = url;
		this.source_date_added = source_date_added;
		this.updated = updated;
		this.rank = rank;
		this.dirname = dirname;
		this.list_type = list_type;
		this.adaptor = adaptor;
		this.downloader = downloader;
		this.md5 = md5;
	}

	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getSource_date_added() {
		return source_date_added;
	}
	public void setSource_date_added(Date source_date_added) {
		this.source_date_added = source_date_added;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
	public String getDirname() {
		return dirname;
	}
	public void setDirname(String dirname) {
		this.dirname = dirname;
	}
	public String getList_type() {
		return list_type;
	}
	public void setList_type(String list_type) {
		this.list_type = list_type;
	}
	public String getAdaptor() {
		return adaptor;
	}
	public void setAdaptor(String adaptor) {
		this.adaptor = adaptor;
	}
	public String getDownloader() {
		return downloader;
	}
	public void setDownloader(String downloader) {
		this.downloader = downloader;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public Collection<IpV4Address> getIpv4Set() {
		return ipv4Set;
	}
	public void setIpv4Set(Collection<IpV4Address> ipv4Set) {
		this.ipv4Set = ipv4Set;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public Collection<IpV6Address> getIpv6Set() {
		return ipv6Set;
	}

	public void setIpv6Set(Collection<IpV6Address> ipv6Set) {
		this.ipv6Set = ipv6Set;
	}
	
	// public Set<NotValidIp> getNotValidIpSet() {
	// return notValidIpSet;
	// }
	// public void setNotValidIpSet(Set<NotValidIp> notValidIpSet) {
	// this.notValidIpSet = notValidIpSet;
	// }

}