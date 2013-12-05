package tc.lv.utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {

    public static List<String> createErrorList(Exception e) {
        ArrayList<String> errorList = new ArrayList<String>();
        Exception cause = e;

        while (cause.getCause() != null) {
            cause = (Exception) cause.getCause();
        }

        for (StackTraceElement ste : cause.getStackTrace()) {
            errorList.add(ste.toString());
        }

        return errorList;
    }
}
