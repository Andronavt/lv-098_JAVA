package tc.lv.exceptions;

public class DownloadIllegalAccessException extends DownloadException {
    /**
     * 
     */
    private static final long serialVersionUID = 1694826724818063965L;

    public DownloadIllegalAccessException() {
    }

    public DownloadIllegalAccessException(String msg) {
	super(msg);
    }
}
