package tc.lv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "settings_for_pagination")
@NamedQueries({
// -----
@NamedQuery(name = PaginationSettings.FIND_ALL, query = PaginationSettings.FIND_ALL_QUERY)
// -----
})
public class PaginationSettings {
    public static final String FIND_ALL = "PaginationSettings.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ps from PaginationSettings ps";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    int id;

    @Column(name = "ips_per_page")
    Integer ipsPerPage;

    public PaginationSettings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIpsPerPage() {
        return ipsPerPage;
    }

    public void setIpsPerPage(Integer ipsPerPage) {
        this.ipsPerPage = ipsPerPage;
    }

}
