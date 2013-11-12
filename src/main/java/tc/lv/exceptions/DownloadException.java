package tc.lv.exceptions;

public class DownloadException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -1733773955555351297L;

    public DownloadException() {
    }

    public DownloadException(String msg) {
	super(msg);
    }

    public DownloadException(String msg, Exception e) {
	super(msg, e);
    }

}
