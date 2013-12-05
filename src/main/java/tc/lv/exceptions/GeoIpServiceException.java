package tc.lv.exceptions;

public class GeoIpServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -3362281624829742664L;

    private String msg;

    public GeoIpServiceException() {
    }

    public GeoIpServiceException(String msg) {
        super(msg);
    }

    public GeoIpServiceException(String msg, Exception e) {
        super(msg, e);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
