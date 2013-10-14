package Test.First.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpV6Validator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String REGEX = "[a-f0-9]{1,4}:([a-f0-9]{0,4}:){1,6}[a-f0-9]{1,4}";

	public IpV6Validator() {
		pattern = Pattern.compile(REGEX);
	}

	public boolean validate(final String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
}
