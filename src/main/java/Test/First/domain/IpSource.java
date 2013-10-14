package Test.First.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IpSource {

	private int id;
	private String source_name;
	private String url;
	private Date source_date_added;
	private Date updated;
	private double rank;
	private String dirname;
	private String list_type;
	private String adaptor;
	private String downloader;
	private String md5;

	private Set<ipv4_addresses> ipv4Set = new HashSet<ipv4_addresses>(0);
	private Set<ipv6_addresses> ipv6Set = new HashSet<ipv6_addresses>(0);

	public IpSource(String source_name, String url, Date source_date_added,
			Date updated, double rank, String dirname, String list_type,
			String adaptor, String downloader, String md5) {
		super();
		this.source_name = source_name;
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

	public Set<ipv4_addresses> getIpv4Set() {
		return ipv4Set;
	}

	public void setIpv4Set(Set<ipv4_addresses> ipv4Set) {
		this.ipv4Set = ipv4Set;
	}

	public Set<ipv6_addresses> getIpv6Set() {
		return ipv6Set;
	}

	public void setIpv6Set(Set<ipv6_addresses> ipv6Set) {
		this.ipv6Set = ipv6Set;
	}

	public IpSource() {
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
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

}
