package tc.lv.exceptions;

public class ParserResultServiceException extends IPException {

    /**
	 * 
	 */
    private static final long serialVersionUID = 784072323025252902L;

    public ParserResultServiceException() {

    }

    public ParserResultServiceException(String msg) {
        super(msg);
    }

    public ParserResultServiceException(String msg, Exception e) {
        super(msg, e);
    }

}
