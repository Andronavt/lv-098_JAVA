package tc.lv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv4_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({ @NamedQuery(name = IpV4Address.GET_ALL, query = IpV4Address.GET_ALL_QUERY),
        @NamedQuery(name = IpV4Address.GET_BY_SOURCE, query = IpV4Address.GET_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BY_ADDRESS, query = IpV4Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV4Address.GET_WHITELIST, query = IpV4Address.GET_WHITELIST_QUERY),
        @NamedQuery(name = IpV4Address.GET_UNDEFINEDLIST, query = IpV4Address.GET_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_IP_BY_NAME, query = IpV4Address.FIND_WHITE_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BLACK_IP_BY_NAME, query = IpV4Address.FIND_BLACK_IP_BY_NAME_QUERY) })
public class IpV4Address extends IpAddressImpl implements Serializable {

    public static final String FIND_BLACK_IP_BY_NAME = "IpV4Address.findBlackIpByName";
    public static final String FIND_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = FALSE and ip.address = ?1";

    public static final String FIND_BY_ADDRESS = "IpV4Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV4Address ip WHERE ip.address= ?1";

    public static final String FIND_WHITE_IP_BY_NAME = "IpV4Address.findWhiteIpByName";
    public static final String FIND_WHITE_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = TRUE and ip.address = ?1";

    public static final String GET_ALL = "IpV4Address.getAll";
    public static final String GET_ALL_QUERY = "SELECT ip from IpV4Address ip";

    public static final String GET_BY_SOURCE = "IpV4Address.getBySource";
    public static final String GET_BY_SOURCE_QUERY = "SELECT ip from IpV4Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String GET_UNDEFINEDLIST = "IpV4Address.getUndefinedList";
    public static final String GET_UNDEFINEDLIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList is null";

    public static final String GET_WHITELIST = "IpV4Address.getWhiteList";
    public static final String GET_WHITELIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1";

    public IpV4Address() {

    }

    public IpV4Address(String address) {
        this.address = address;
    }

    public IpV4Address(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }

    @Override
    public String getFindBlackIpByName() {
        return FIND_BLACK_IP_BY_NAME;
    }

    @Override
    public String getFindByAddress() {
        return FIND_BY_ADDRESS;
    }

    @Override
    public String getFindWhiteIpByName() {
        return FIND_WHITE_IP_BY_NAME;
    }

    @Override
    public String getGetAll() {
        return GET_ALL;
    }

    @Override
    @Deprecated
    public String getGetAllNotValid() {
        return null;
    }

    @Override
    @Deprecated
    public String getGetAllValid() {
        return null;
    }

    @Override
    public String getGetBySource() {
        return GET_BY_SOURCE;
    }

    @Override
    public String getGetUndefinedlist() {
        return GET_UNDEFINEDLIST;
    }

    @Override
    public String getGetWhitelist() {
        return GET_WHITELIST;
    }

}
