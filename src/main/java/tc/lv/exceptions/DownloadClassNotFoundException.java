package tc.lv.exceptions;

public class DownloadClassNotFoundException extends DownloadException {
    /**
     * 
     */
    private static final long serialVersionUID = -5043694834552217337L;

    public DownloadClassNotFoundException() {
    }

    public DownloadClassNotFoundException(String msg) {
	super(msg);
    }
}
