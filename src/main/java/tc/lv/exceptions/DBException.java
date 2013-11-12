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

<<<<<<< HEAD
    public DBException(String msg) {
	super(msg);
    }

    public DBException(String msg, Exception e) {
	super(msg, e);
    }
=======
	public DBException(String msg, Exception e) {
		super(msg, e);
	}
>>>>>>> 8ffe6ca5b21b4e89a9c8e3668f519459a10e4f17
}
