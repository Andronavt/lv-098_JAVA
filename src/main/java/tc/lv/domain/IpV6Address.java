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
@NamedQueries({ @NamedQuery(name = IpV6Address.GET_ALL, query = IpV6Address.GET_ALL_QUERY),
        @NamedQuery(name = IpV6Address.GET_BY_SOURCE, query = IpV6Address.GET_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV6Address.FIND_BY_ADDRESS, query = IpV6Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV6Address.GET_WHITELIST, query = IpV6Address.GET_WHITELIST_QUERY),
        @NamedQuery(name = IpV6Address.GET_UNDEFINEDLIST, query = IpV6Address.GET_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_IP_BY_NAME, query = IpV6Address.FIND_WHITE_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV6Address.FIND_BLACK_IP_BY_NAME, query = IpV6Address.FIND_BLACK_IP_BY_NAME_QUERY) })
public class IpV6Address extends IpAddress {

    public static final String FIND_BLACK_IP_BY_NAME = "IpV6Address.findBlackIpByName";
    public static final String FIND_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = FALSE and ip.address = ?1";

    public static final String FIND_BY_ADDRESS = "IpV6Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV6Address ip WHERE ip.address= ?1";

    public static final String FIND_WHITE_IP_BY_NAME = "IpV6Address.findWhiteIpByName";
    public static final String FIND_WHITE_IP_BY_NAME_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = TRUE and ip.address = ?1";

    public static final String GET_ALL = "IpV6Address.getAll";
    public static final String GET_ALL_QUERY = "SELECT ip from IpV6Address ip";

    public static final String GET_BY_SOURCE = "IpV6Address.getBySource";
    public static final String GET_BY_SOURCE_QUERY = "SELECT ip from IpV6Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String GET_UNDEFINEDLIST = "IpV6Address.getUndefinedList";
    public static final String GET_UNDEFINEDLIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList is null";

    public static final String GET_WHITELIST = "IpV6Address.getWhiteList";
    public static final String GET_WHITELIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1";

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
