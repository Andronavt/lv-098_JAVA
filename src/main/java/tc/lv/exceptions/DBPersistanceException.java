package tc.lv.exceptions;

public class DBPersistanceException extends DBException {
    /**
     * 
     */
    private static final long serialVersionUID = 4019710833561232173L;

    public DBPersistanceException() {
    }

    public DBPersistanceException(String msg) {
	super(msg);
    }
}
