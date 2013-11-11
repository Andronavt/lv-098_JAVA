package tc.lv.exceptions;

public class DBIllegalStateException extends DBException {
    /**
     * 
     */
    private static final long serialVersionUID = 5067880364175916751L;

    public DBIllegalStateException() {
    }

    public DBIllegalStateException(String msg) {
	super(msg);
    }
}
