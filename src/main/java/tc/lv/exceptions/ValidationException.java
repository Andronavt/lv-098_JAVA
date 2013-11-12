package tc.lv.exceptions;

public class ValidationException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = 1551178547230318827L;

    public ValidationException() {
    }

    public ValidationException(String msg) {
	super(msg);
    }

    public ValidationException(String msg, Exception e) {
	super(msg, e);
    }

}
