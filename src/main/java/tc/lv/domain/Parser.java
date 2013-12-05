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
        @NamedQuery(name = Parser.FIND_DIR_BY_NAME, query = Parser.FIND_DIR_BY_NAME_QUERY)

// -----
})
public class Parser {

    public static final String FIND_ALL = "Parser.findAll";
    static final String FIND_ALL_QUERY = "SELECT p FROM Parser p";

    public static final String FIND_DIR_BY_NAME = "Parser.findDirByName";
    static final String FIND_DIR_BY_NAME_QUERY = "SELECT p.dir FROM Parser p WHERE p.name = ?1";

    public Parser() {

    }

    public Parser(String name, String dir) {
        this.name = name;
        this.dir = dir;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dir")
    private String dir;

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

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((dir == null) ? 0 : dir.hashCode());
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
        Parser other = (Parser) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (dir == null) {
            if (other.dir != null)
                return false;
        } else if (!dir.equals(other.dir))
            return false;
        return true;
    }

}
