package tc.lv.exceptions;

public class BlackListServiceException extends DBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -993591282264002666L;

	public BlackListServiceException() {

	}

	public BlackListServiceException(String msg) {
		super(msg);
	}

	public BlackListServiceException(String msg, Exception e) {
		super(msg, e);
	}

}
