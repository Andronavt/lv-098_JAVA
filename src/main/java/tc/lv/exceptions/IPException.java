package tc.lv.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class IPException extends Exception {
    /**
     * 
     */

    private static final long serialVersionUID = -3873888718676301070L;
    private static final Logger logger = Logger.getLogger("errorLog");

    private String msg;

    public IPException() {
	StringWriter trace = new StringWriter();
	printStackTrace(new PrintWriter(trace));
	logger.error(trace.toString());
    }

    public IPException(String msg) {
	super(msg);
	StringWriter trace = new StringWriter();
	printStackTrace(new PrintWriter(trace));
	logger.error(trace.toString());
	this.msg = msg;
    }

    public IPException(String msg, Exception e) {
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
