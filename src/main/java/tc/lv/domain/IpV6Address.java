package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv6_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
        // ---
        @NamedQuery(name = IpV6Address.COUNT_ALL, query = IpV6Address.COUNT_ALL_QUERY),
        @NamedQuery(name = IpV6Address.FIND_ALL, query = IpV6Address.FIND_ALL_QUERY),
        @NamedQuery(name = IpV6Address.FIND_BY_SOURCE, query = IpV6Address.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV6Address.FIND_BY_ADDRESS, query = IpV6Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_LIST, query = IpV6Address.FIND_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_UNDEFINEDLIST, query = IpV6Address.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME, query = IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY),
// @NamedQuery(name = IpV6Address.FIND_BLACK_IP_BY_NAME, query =
// IpV6Address.FIND_BLACK_IP_BY_NAME_QUERY)
// ---
})
public class IpV6Address extends IpAddress {

    // public static final String FIND_BLACK_IP_BY_NAME =
    // "IpV6Address.findBlackIpByName";
    // public static final String FIND_BLACK_IP_BY_NAME_QUERY =
    // "SELECT ip from IpV6Address ip where ip.whiteList = FALSE and ip.address = ?1";

    public static final String COUNT_ALL = "IpV6Address.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpV6Address ip";

    public static final String FIND_ALL = "IpV6Address.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpV6Address ip";

    public static final String FIND_BY_ADDRESS = "IpV6Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV6Address ip WHERE ip.address= ?1";

    public static final String FIND_BY_SOURCE = "IpV6Address.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpV6Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpV6Address.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList is null";

    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME = "IpV6Address.findWhiteOrBlackIpByName";
    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1 and ip.address = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST = "IpV6Address.findWhiteOrBlackList";
    public static final String FIND_WHITE_OR_BLACK_LIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1";

    public IpV6Address() {

    }

    public IpV6Address(String address) {
        this.address = address;
    }

    public IpV6Address(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }
}
