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
@Table(name = "parsers")
@NamedQueries({
        // -----
        @NamedQuery(name = Parser.FIND_ALL, query = Parser.FIND_ALL_QUERY),
        @NamedQuery(name = Parser.FIND_URL_BY_NAME, query = Parser.FIND_URL_BY_NAME_QUERY)

// -----
})
public class Parser {

    public static final String FIND_ALL = "Parser.findAll";
    static final String FIND_ALL_QUERY = "SELECT p FROM Parser p";

    public static final String FIND_URL_BY_NAME = "Parser.findUrlByName";
    static final String FIND_URL_BY_NAME_QUERY = "SELECT p.url FROM Parser p WHERE p.name = ?1";

    public Parser() {

    }

    public Parser(String name, String url) {
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
