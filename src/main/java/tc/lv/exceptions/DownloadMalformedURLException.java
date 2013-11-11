package tc.lv.exceptions;

public class DownloadMalformedURLException extends DownloadException {
    /**
     * 
     */
    private static final long serialVersionUID = -8120694210616131495L;

    public DownloadMalformedURLException() {
    }

    public DownloadMalformedURLException(String msg) {
	super(msg);
    }
}
