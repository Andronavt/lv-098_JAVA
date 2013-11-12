package tc.lv.exceptions;

public class DBLoginExistException extends DBException {
    /**
     * 
     */
    private static final long serialVersionUID = -2110106921575464516L;

    public DBLoginExistException() {
    }

    public DBLoginExistException(String msg) {
	super(msg);
    }

}
