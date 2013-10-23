package tc.lv.domain;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "sources")
public class Source {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "source_id", nullable = false)
	private int sourceId;

	@Column(name = "source_name", nullable = false)
	private String sourceName;

	@Column(name = "url", unique = true, nullable = false)
	private String url;

	@Column(name = "source_date_added", nullable = false)
	private Date source_date_added;

	@Column(name = "updated", nullable = false)
	private Date updated;

	@Column(name = "rank", nullable = false)
	private Double rank;

	@Column(name = "dirname", nullable = false)
	private String dirname;

	@Column(name = "list_type", nullable = false)
	private String list_type;

	@Column(name = "adaptor", nullable = false)
	private String adaptor;

	@Column(name = "downloader", nullable = false)
	private String downloader;

	@Column(name = "md5")
	private String md5;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "source_id") }, inverseJoinColumns = { @JoinColumn(name = "v4_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	private Collection<IpV4Address> ipv4Set = new HashSet<IpV4Address>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "source_id") }, inverseJoinColumns = { @JoinColumn(name = "v6_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	private Collection<IpV6Address> ipv6Set = new HashSet<IpV6Address>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "source_id") }, inverseJoinColumns = { @JoinColumn(name = "not_valid_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	private Collection<NotValidIp> notValidSet = new HashSet<NotValidIp>();

	public Source() {

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

	public Collection<NotValidIp> getNotValidSet() {
		return notValidSet;
	}

	public void setNotValidSet(Collection<NotValidIp> notValidSet) {
		this.notValidSet = notValidSet;
	}

	public Collection<IpV4Address> getIpv4Set() {
		return ipv4Set;
	}

	public void setIpv4Set(Collection<IpV4Address> ipv4Set) {
		this.ipv4Set = ipv4Set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sourceName == null) ? 0 : sourceName.hashCode());
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
		Source other = (Source) obj;
		if (sourceName == null) {
			if (other.sourceName != null)
				return false;
		} else if (!sourceName.equals(other.sourceName))
			return false;
		return true;
	}

	public void addIpToV4Set(IpV4Address ip) {
		ipv4Set.add(ip);
	}

	public void addIpToV6Set(IpV6Address ip) {
		ipv6Set.add(ip);
	}

	public void addIpToNoValidSet(NotValidIp ip) {
		notValidSet.add(ip);
	}

}