package tc.lv.utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {

    public static List<String> createErrorList(Exception e) {

	ArrayList<String> errorList = new ArrayList<String>();
	if (e.getCause() != null) {
	    Exception cause = (Exception) e.getCause();
	    for (StackTraceElement ste : cause.getStackTrace()) {
		errorList.add(ste.toString());
	    }
	} else {
	    for (StackTraceElement ste : e.getStackTrace()) {
		errorList.add(ste.toString());
	    }
	}
	return errorList;
    }
}
