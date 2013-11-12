package tc.lv.exceptions;


public class DBException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -2943018141412512379L;

    public DBException() {
    }

    public DBException(String msg) {
	super(msg);
    }
}
