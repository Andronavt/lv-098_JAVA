package tc.lv.exceptions;

public class UserValidationException extends ValidationException {
    /**
     * 
     */
    private static final long serialVersionUID = -286816761026090630L;
    public UserValidationException() {
    }
    public UserValidationException(String msg) {
	super(msg);
    }
}
