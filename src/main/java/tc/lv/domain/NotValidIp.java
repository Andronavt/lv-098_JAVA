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
@NamedQueries({
        // ---
        @NamedQuery(name = NotValidIp.COUNT_ALL, query = NotValidIp.COUNT_ALL_QUERY),
        @NamedQuery(name = NotValidIp.FIND_ALL, query = NotValidIp.FIND_ALL_QUERY),
        @NamedQuery(name = NotValidIp.FIND_BY_SOURCE, query = NotValidIp.FIND_BY_SOURCE_QUERY)
// ---
})
public class NotValidIp extends IpAddress {

    public static final String COUNT_ALL = "NotValidIp.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from NotValidIp ip";

    public static final String FIND_ALL = "NotValidIp.findByAddress";
    public static final String FIND_ALL_QUERY = "SELECT ip from NotValidIp ip WHERE ip.address= ?1";

    public static final String FIND_BY_SOURCE = "NotValidIp.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from NotValidIp ip join ip.sourceSet s where s.sourceId= ?1";

    public NotValidIp() {

    }

    public NotValidIp(String address) {
        this.address = address;
    }

    public NotValidIp(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }
}
