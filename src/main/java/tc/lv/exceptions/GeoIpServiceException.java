package tc.lv.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class GeoIpServiceException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = 7817826313491770076L;

    private static final Logger logger = Logger.getLogger(GeoIpServiceException.class);

    private String msg;

    public GeoIpServiceException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.error(trace.toString());
    }

    public GeoIpServiceException(String msg) {
        super(msg);
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.error(trace.toString());
        this.msg = msg;
    }

    public GeoIpServiceException(String msg, Exception e) {
        super(msg, e);
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.error(trace.toString());
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
