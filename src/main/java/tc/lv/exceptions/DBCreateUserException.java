package tc.lv.exceptions;

public class DBCreateUserException extends DBException {

    private static final long serialVersionUID = 2955931995418867596L;

    public DBCreateUserException() {

    }

    public DBCreateUserException(String msg) {
	super(msg);
    }
}
