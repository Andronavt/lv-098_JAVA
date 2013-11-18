package tc.lv.exceptions;

public class GeoIpServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = 7817826313491770076L;

    public GeoIpServiceException() {
    }

    public GeoIpServiceException(String msg) {
        super(msg);
    }

    public GeoIpServiceException(String msg, Exception e) {
        super(msg, e);
    }

}
