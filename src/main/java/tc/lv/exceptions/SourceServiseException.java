package tc.lv.exceptions;

public class SourceServiseException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -2121865119422521202L;

    public SourceServiseException() {
    }

    public SourceServiseException(String msg) {
        super(msg);
    }

    public SourceServiseException(String msg, Exception e) {
        super(msg, e);
    }
}
