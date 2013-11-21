package tc.lv.exceptions;

public class SourceDownloaderServiceException extends IPException {

    /**
	 * 
	 */
    private static final long serialVersionUID = -2068090609528047966L;

    public SourceDownloaderServiceException() {

    }

    public SourceDownloaderServiceException(String msg) {
        super(msg);
    }

    public SourceDownloaderServiceException(String msg, Exception e) {
        super(msg, e);
    }
}
