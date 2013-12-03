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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ipsPerPage == null) ? 0 : ipsPerPage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PaginationSettings other = (PaginationSettings) obj;
        if (ipsPerPage == null) {
            if (other.ipsPerPage != null)
                return false;
        } else if (!ipsPerPage.equals(other.ipsPerPage))
            return false;
        return true;
    }

    
}
