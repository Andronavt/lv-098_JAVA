package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "not_valid_ip")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({ @NamedQuery(name = NotValidIp.GET_ALL, query = NotValidIp.GET_ALL_QUERY),
        @NamedQuery(name = NotValidIp.GET_BY_SOURCE, query = NotValidIp.GET_BY_SOURCE_QUERY) })
public class NotValidIp extends IpAddressImpl {

    public static final String GET_ALL = "NotValidIp.findByAddress";
    public static final String GET_ALL_QUERY = "SELECT ip from NotValidIp ip WHERE ip.address= ?1";

    public static final String GET_BY_SOURCE = "NotValidIp.getBySource";
    public static final String GET_BY_SOURCE_QUERY = "SELECT ip from NotValidIp ip join ip.sourceSet s where s.sourceId= ?1";

    public NotValidIp() {

    }

    public NotValidIp(String address) {
        this.address = address;
    }

    public NotValidIp(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }

    @Override
    @Deprecated
    public String getFindBlackIpByName() {
        return null;
    }

    @Override
    @Deprecated
    public String getFindByAddress() {
        return null;
    }

    @Override
    @Deprecated
    public String getFindWhiteIpByName() {
        return null;
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
    @Deprecated
    public String getGetUndefinedlist() {
        return null;
    }

    @Override
    @Deprecated
    public String getGetWhitelist() {
        return null;
    }

}
