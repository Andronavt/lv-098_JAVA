package tc.lv.exceptions;

public class LocationServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -7682510556706339437L;

    public LocationServiceException() {
    }

    public LocationServiceException(String msg) {
        super(msg);
    }

    public LocationServiceException(String msg, Exception e) {
        super(msg, e);
    }
}
