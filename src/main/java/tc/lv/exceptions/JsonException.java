package tc.lv.exceptions;


public class JsonException extends IPException {
    /**
     * 
     */
    private static final long serialVersionUID = -4223701569266786545L;

    public JsonException() {
    }

    public JsonException(String msg) {
        super(msg);
    }

    public JsonException(String msg, Exception e) {
        super(msg, e);
    }

}
