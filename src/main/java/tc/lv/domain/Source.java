package tc.lv.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "sources")
@NamedQueries({
		@NamedQuery(name = "Source.getAll", query = "SELECT c FROM Source c"),
		@NamedQuery(name = "Source.findByName", query = "SELECT c FROM Source c WHERE c.sourceName  = :sourceName") })
public class Source {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "source_id", nullable = false)
	private int sourceId;

	@Column(name = "source_name", nullable = false)
	private String sourceName;

	@Column(name = "url", unique = true, nullable = true)
	private String url;

	@Column(name = "source_date_added", nullable = false)
	private Date sourceDateAdded;

	@Column(name = "rank", nullable = false)
	private Double rank;

	@Column(name = "dirname", nullable = false)
	private String dirname;

	@Column(name = "list_type", nullable = false)
	private String listType;

	@Column(name = "updated", nullable = true)
	private Date updated;

	@Column(name = "parser", nullable = true)
	private String parser;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "sourceSet", fetch = FetchType.LAZY)
	private Collection<IpAddress> ipSet = new HashSet<IpAddress>();

	public Source() {

	}

	public Source(String parser, String sourceName, String url,
			String listType, Double rank) {
		super();
		this.parser = parser;
		this.sourceName = sourceName;
		this.sourceDateAdded = new Date();
		this.rank = rank;
		this.dirname = "d://lv-098_JAVA//sources//" + sourceName + "//";
		this.listType = listType;
	}

	public Source(String sourceName, String url, Date sourceDateAdded,
			Double rank, String dirname, String listType, Date updated,
			String parser, Collection<IpAddress> ipSet) {
		super();
		this.sourceName = sourceName;
		this.url = url;
		this.sourceDateAdded = sourceDateAdded;
		this.rank = rank;
		this.dirname = dirname;
		this.listType = listType;
		this.updated = updated;
		this.parser = parser;

		this.ipSet = ipSet;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
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

	public Date getSourceDateAdded() {
		return sourceDateAdded;
	}

	public void setSourceDateAdded(Date sourceDateAdded) {
		this.sourceDateAdded = sourceDateAdded;
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public String getDirname() {
		return dirname;
	}

	public void setDirname(String dirname) {
		this.dirname = dirname;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}

	public Collection<IpAddress> getIpSet() {
		return ipSet;
	}

	public void setIpSet(Collection<IpAddress> ipSet) {
		this.ipSet = ipSet;
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

}