package tc.lv.exceptions;

public class IpStatusListServiceException extends IPException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -15378726266148177L;

	public IpStatusListServiceException() {

	}

	public IpStatusListServiceException(String msg) {
		super(msg);
	}

	public IpStatusListServiceException(String msg, Exception e) {
		super(msg, e);
	}

}
