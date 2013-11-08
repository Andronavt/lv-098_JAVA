package tc.lv.exceptions;


public class DBIllegalArgumentException extends DBException {
    /**
     * 
     */
    private static final long serialVersionUID = -2642631346193587897L;

    public DBIllegalArgumentException() {
    }

    public DBIllegalArgumentException(String msg) {
	super(msg);
    }
}
