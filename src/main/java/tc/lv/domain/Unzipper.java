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
@Table(name = "unzippers")
@NamedQueries({
        // -----
        @NamedQuery(name = Unzipper.FIND_ALL, query = Unzipper.FIND_ALL_QUERY),
        @NamedQuery(name = Unzipper.FIND_URL_BY_NAME, query = Unzipper.FIND_URL_BY_NAME_QUERY)

// -----
})
public class Unzipper {

    public static final String FIND_ALL = "Unzipper.findAll";
    static final String FIND_ALL_QUERY = "SELECT u FROM Unzipper u";

    public static final String FIND_URL_BY_NAME = "Unzipper.findUrlByName";
    static final String FIND_URL_BY_NAME_QUERY = "SELECT u.url FROM Unzipper u WHERE u.name = ?1";

    public Unzipper() {

    }

    public Unzipper(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        Unzipper other = (Unzipper) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    
}
