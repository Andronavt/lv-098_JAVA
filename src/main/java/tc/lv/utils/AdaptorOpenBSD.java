/**
 * 
 */
package tc.lv.utils;

import java.io.BufferedReader;
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

/**
 * @author Bohdan
 * 
 */
public class AdaptorOpenBSD {
    private static final Logger log = Logger
	    .getLogger(AdaptorOpenBSD.class);
    private static final String IP_ALL = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";
    private ArrayList<IpV4Address> ip4list = new ArrayList<IpV4Address>();
    private ArrayList<IpV6Address> ip6list = new ArrayList<IpV6Address>();
    private ArrayList<NotValidIp> notValidList = new ArrayList<NotValidIp>();
    private int sourceId;

    AdaptorOpenBSD(String way, int sourceId) {
	Pattern pattern = Pattern.compile(IP_ALL);
	Matcher matcher;
	Scanner line;
	this.sourceId = sourceId;
	try {
	    line = new Scanner(new BufferedReader(new FileReader(way)));
	    while (line.hasNext()) {
		String ipStr = "";
		matcher = pattern.matcher(line.nextLine());
		if (matcher.find()) {
		    ipStr = matcher.group();
		    if (IpValidator.isIpV4(ipStr)) {
			ip4list.add(new IpV4Address(ipStr, new Date()));
		    } else if (IpValidator.isIpV6(ipStr)) {
			ip6list.add(new IpV6Address(ipStr, new Date()));
		    } else {
			notValidList.add(new NotValidIp(ipStr, new Date()));
		    }
		}
	    }
	    line.close();
	} catch (FileNotFoundException e) {
	    log.error("File not found!", e);
	}
    }

    public int getSourceId() {
	return sourceId;
    }

    public ArrayList<IpV4Address> getIpv4List() {
	return ip4list;
    }

    public ArrayList<IpV6Address> getIpv6List() {
	return ip6list;
    }

    public ArrayList<NotValidIp> getNotValidList() {
	return notValidList;
    }

}
