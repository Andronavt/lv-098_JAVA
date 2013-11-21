package tc.lv.exceptions;

public class WhiteListServiceException extends IPException {

    /**
	 * 
	 */
    private static final long serialVersionUID = -15378726266148177L;

    public WhiteListServiceException() {

    }

    public WhiteListServiceException(String msg) {
        super(msg);
    }

    public WhiteListServiceException(String msg, Exception e) {
        super(msg, e);
    }

}
