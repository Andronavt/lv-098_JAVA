package tc.lv.utils;

import java.util.regex.Pattern;

public class IpValidator {

    private static final String IPV4 = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}){1}";
    private static final String IPV6 = "([a-f0-9]{1,4}:([a-f0-9]{1,4}:){1,6}[a-f0-9]{1,4})";
    private static final Pattern patternip4 = Pattern.compile(IPV4);
    private static final Pattern patternip6 = Pattern.compile(IPV6);

    public static boolean isIpV4(String line) {
        return patternip4.matcher(line).find();
    }

    public static boolean isIpV6(String line) {
        return patternip6.matcher(line).find();
    }
}
