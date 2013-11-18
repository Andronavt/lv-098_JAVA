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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ip_addresses")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        // ---
        @NamedQuery(name = IpAddress.COUNT_ALL, query = IpAddress.COUNT_ALL_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_NOT_VALID, query = IpAddress.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_VALID, query = IpAddress.FIND_ALL_VALID_QUERY),
// ---
})
public class IpAddress {

    public static final String COUNT_ALL = "IpAddress.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpAddress ip";

    public static final String FIND_ALL_NOT_VALID = "IpAddress.findAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpAddress ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpAddress.findAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpAddress ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpAddress ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    @Column(name = "address", updatable = true, nullable = false, unique = true)
    protected String address;

    @Column(name = "date_added")
    protected Date dateAdded;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected int id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "sources_to_addresses", joinColumns = { @JoinColumn(name = "ip_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
    @Fetch(FetchMode.JOIN)
    private Set<Source> sourceSet = new HashSet<Source>();

    @Column(name = "white_list")
    protected Boolean whiteList;

    public IpAddress() {
    }

    public void addElementToSourceSet(Source source) {
        sourceSet.add(source);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getAddress().equals(((IpAddress) obj).getAddress());
    }

    public String getAddress() {
        return address;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return address;
    }

    public Set<Source> getSourceSet() {
        return sourceSet;
    }

    public Boolean getWhiteList() {
        return this.whiteList;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSourceSet(Set<Source> sourceSet) {
        this.sourceSet = sourceSet;
    }

    public void setWhiteList(Boolean whiteList) {
        this.whiteList = whiteList;
    }

}
