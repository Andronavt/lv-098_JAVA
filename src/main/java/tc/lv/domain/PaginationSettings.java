package tc.lv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings_for_pagination")
public class PaginationSettings {

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
