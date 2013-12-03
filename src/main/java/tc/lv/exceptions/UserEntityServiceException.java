package tc.lv.exceptions;

public class UserEntityServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = 7782837880985738123L;

    public UserEntityServiceException() {
    }

    public UserEntityServiceException(String msg) {
        super(msg);
    }

    public UserEntityServiceException(String msg, Exception e) {
        super(msg, e);
    }
}
