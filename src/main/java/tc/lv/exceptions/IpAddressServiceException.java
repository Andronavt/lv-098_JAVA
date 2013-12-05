package tc.lv.exceptions;

public class IpAddressServiceException extends IPException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 234297376675447502L;

	public IpAddressServiceException() {

	}

	public IpAddressServiceException(String msg) {
		super(msg);
	}

	public IpAddressServiceException(String msg, Exception e) {
		super(msg, e);
	}
	
}
