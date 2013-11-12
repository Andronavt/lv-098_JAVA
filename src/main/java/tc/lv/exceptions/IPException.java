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

	private String exceptionMsg;

	public IPException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.error(trace.toString());
	}

	public IPException(String msg) {
		super(msg);
		this.exceptionMsg = msg;
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.error(trace.toString());
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
