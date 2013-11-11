package tc.lv.exceptions;

public class DownloadFileNotFoundException extends DownloadException {
    /**
     * 
     */
    private static final long serialVersionUID = 5214768578773314568L;

    public DownloadFileNotFoundException() {
    }

    public DownloadFileNotFoundException(String msg) {
	super(msg);
    }
}
