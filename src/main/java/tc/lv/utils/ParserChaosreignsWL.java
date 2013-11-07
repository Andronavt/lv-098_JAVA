package tc.lv.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public class ParserChaosreignsWL implements ParserInterface {
	private static final Logger log = Logger
			.getLogger(ParserChaosreignsWL.class);
	private ParserResults parserResults;
	protected static final String IP_ALL = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";

	public ParserChaosreignsWL() {
		parserResults = new ParserResults();
	}

	@Override
	public ParserResults parse(File f) {
		Pattern pattern = Pattern.compile(IP_ALL);
		Matcher matcher;
		Scanner line;
		try {
			line = new Scanner(new BufferedReader(new FileReader(f)));
			while (line.hasNext()) {
				String ipStr = "";
				matcher = pattern.matcher(line.nextLine());
				if (matcher.find()) {
					ipStr = matcher.group();
					if (IpValidator.isIpV4(ipStr)) {
						parserResults.ip4List.add(new IpV4Address(ipStr,
								new Date()));
					} else if (IpValidator.isIpV6(ipStr)) {
						parserResults.ip6List.add(new IpV6Address(ipStr,
								new Date()));
					} else {
						parserResults.notValidList.add(new NotValidIp(ipStr,
								new Date()));
					}
				}
			}
			line.close();
		} catch (FileNotFoundException e) {
			log.error("File not found!", e);
		}
		System.out.println("IPV4SIZE "+parserResults.ip4List.size());
		return parserResults;
	}

}
