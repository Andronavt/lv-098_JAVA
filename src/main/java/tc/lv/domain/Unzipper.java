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

}
