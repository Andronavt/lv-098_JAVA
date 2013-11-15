package tc.lv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {

    private static final String IPV4 = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";
    private static final String IPV6 = "[a-f0-9]{1,4}:([a-f0-9]{0,4}:){1,6}[a-f0-9]{1,4}";
    private static final Pattern patternip4 = Pattern.compile(IPV4);
    private static final Pattern patternip6 = Pattern.compile(IPV6);

    public static boolean isIpV4(String line) {

	Matcher matcher;
	matcher = patternip4.matcher(line);

	return ((matcher.find()) ? line.equals(matcher.group()) : false);
    }

    public static boolean isIpV6(String line) {

	Matcher matcher;
	matcher = patternip6.matcher(line);

	return ((matcher.find()) ? line.equals(matcher.group()) : false);
    }

}
