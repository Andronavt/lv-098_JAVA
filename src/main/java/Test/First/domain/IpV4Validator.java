package Test.First.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpV4Validator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String REGEX = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public IpV4Validator() {
		pattern = Pattern.compile(REGEX);
	}

	public boolean validate(final String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
}
