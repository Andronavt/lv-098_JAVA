package tc.lv.exceptions;


public class JsonServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -4223701569266786545L;

    public JsonServiceException() {
    }

    public JsonServiceException(String msg) {
        super(msg);
    }

    public JsonServiceException(String msg, Exception e) {
        super(msg, e);
    }

}
