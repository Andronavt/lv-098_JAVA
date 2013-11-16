package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv4_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({ @NamedQuery(name = IpV4Address.FIND_ALL, query = IpV4Address.FIND_ALL_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BY_SOURCE, query = IpV4Address.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BY_ADDRESS, query = IpV4Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITELIST, query = IpV4Address.FIND_WHITELIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_UNDEFINEDLIST, query = IpV4Address.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_IP_BY_NAME, query = IpV4Address.FIND_WHITE_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BLACK_IP_BY_NAME, query = IpV4Address.FIND_BLACK_IP_BY_NAME_QUERY) })
public class IpV4Address extends IpAddress {

    public static final String FIND_BLACK_IP_BY_NAME = "IpV4Address.findBlackIpByName";
    public static final String FIND_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = FALSE and ip.address = ?1";

    public static final String FIND_BY_ADDRESS = "IpV4Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV4Address ip WHERE ip.address= ?1";

    public static final String FIND_WHITE_IP_BY_NAME = "IpV4Address.findWhiteIpByName";
    public static final String FIND_WHITE_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = TRUE and ip.address = ?1";

    public static final String FIND_ALL = "IpV4Address.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpV4Address ip";

    public static final String FIND_BY_SOURCE = "IpV4Address.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpV4Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpV4Address.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList is null";

    public static final String FIND_WHITELIST = "IpV4Address.findWhiteList";
    public static final String FIND_WHITELIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1";

    public IpV4Address() {

    }

    public IpV4Address(String address) {
        this.address = address;
    }

    public IpV4Address(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }
}
