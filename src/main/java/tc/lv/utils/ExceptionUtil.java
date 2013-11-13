package tc.lv.utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {
    public static List<String> createErrorList(Exception e) {
	ArrayList<String> errorList = new ArrayList<String>();
	ArrayList<String> errorListTmp = new ArrayList<String>();
	for (StackTraceElement ste : e.getStackTrace()) {
	    errorListTmp.add(ste.toString());
	}
	for (int i = 0; i < errorListTmp.size(); i++) {
	    if (errorListTmp.get(i).contains("ERROR")
		    || errorListTmp.get(i).contains("Caused by")) {
		errorList.add(errorListTmp.get(++i));
		errorList.add(errorListTmp.get(++i));
		errorList.add(errorListTmp.get(++i));
	    }
	}
	return errorListTmp;
    }
}
