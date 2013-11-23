package tc.lv.exceptions;

public class GeoIpException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = 7817826313491770076L;

    private String msg;

    public GeoIpException() {
    }

    public GeoIpException(String msg) {
        super(msg);
    }

    public GeoIpException(String msg, Exception e) {
        super(msg, e);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
