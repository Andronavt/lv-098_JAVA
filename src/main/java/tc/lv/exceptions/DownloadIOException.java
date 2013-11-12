package tc.lv.exceptions;

public class DownloadIOException extends DownloadException {
    /**
     * 
     */
    private static final long serialVersionUID = -6448338347489081313L;

    public DownloadIOException() {
    }

    public DownloadIOException(String msg) {
	super(msg);
    }
}
