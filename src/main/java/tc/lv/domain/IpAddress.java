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
        @NamedQuery(name = IpAddress.FIND_ALL_NOT_VALID, query = IpAddress.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_VALID, query = IpAddress.FIND_ALL_VALID_QUERY),
        // ----------------------------------------------------------
        @NamedQuery(name = IpAddress.FIND_ALL, query = IpAddress.FIND_ALL_QUERY),
        @NamedQuery(name = IpAddress.FIND_BY_SOURCE, query = IpAddress.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpAddress.FIND_BY_ADDRESS, query = IpAddress.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITELIST, query = IpAddress.FIND_WHITELIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_UNDEFINEDLIST, query = IpAddress.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITE_IP_BY_NAME, query = IpAddress.FIND_WHITE_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpAddress.FIND_BLACK_IP_BY_NAME, query = IpAddress.FIND_BLACK_IP_BY_NAME_QUERY)
// ----------------------------------------------------------
})
public class IpAddress {

    public static final String FIND_ALL_NOT_VALID = "IpAddress.getAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpAddress ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpAddress.getAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpAddress ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpAddress ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    // ----------------------------------------------------------
    public static final String FIND_ALL = "IpAddress.getAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpAddress ip";

    public static final String FIND_BY_SOURCE = "IpAddress.getBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpAddress ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_BY_ADDRESS = "IpAddress.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpAddress ip WHERE ip.address= ?1";

    public static final String FIND_WHITELIST = "IpAddress.getWhiteList";
    public static final String FIND_WHITELIST_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpAddress.getUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpAddress ip where ip.whiteList is null";

    public static final String FIND_WHITE_IP_BY_NAME = "IpAddress.findWhiteIpByName";
    public static final String FIND_WHITE_IP_BY_NAME_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = TRUE and ip.address = ?1";

    public static final String FIND_BLACK_IP_BY_NAME = "IpAddress.findBlackIpByName";
    public static final String FIND_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = FALSE and ip.address = ?1";
    // ------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected int id;

    @Column(name = "address", updatable = true, nullable = false, unique = true)
    protected String address;

    @Column(name = "date_added")
    protected Date dateAdded;

    @Column(name = "white_list")
    protected Boolean whiteList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "sources_to_addresses", joinColumns = { @JoinColumn(name = "ip_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
    @Fetch(FetchMode.JOIN)
    private Set<Source> sourceSet = new HashSet<Source>();

    public IpAddress() {
    }

    public int getId() {
        return id;
    }

    public Boolean getWhiteList() {
        return this.whiteList;
    }

    public void setWhiteList(Boolean whiteList) {
        this.whiteList = whiteList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIp() {
        return address;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getAddress().equals(((IpAddress) obj).getAddress());
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
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
