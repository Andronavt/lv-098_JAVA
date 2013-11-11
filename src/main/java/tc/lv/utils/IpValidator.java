package tc.lv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpValidator {
	private static final String IPv4 = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
	private static final String IPv6 = "[a-f0-9]{1,4}:([a-f0-9]{0,4}:){1,6}[a-f0-9]{1,4}";

	public static boolean isIpV4(String line) {
		Matcher ip4;
		Pattern patternip4 = Pattern.compile(IPv4);
		ip4 = patternip4.matcher(line);
		if (ip4.find()) {
			return true;
		}
		return false;
	}

	public static boolean isIpV6(String line) {
		Matcher ip6;
		Pattern patternip6 = Pattern.compile(IPv6);
		ip6 = patternip6.matcher(line);
		if (ip6.find()) {
			return true;
		}
		return false;
	}

}
