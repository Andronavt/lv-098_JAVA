package tc.lv.utils;

import java.util.ArrayList;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public abstract class Parser {
	protected static final String IP_ALL = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";
	protected ArrayList<IpV4Address> ip4list = new ArrayList<IpV4Address>();
	protected ArrayList<IpV6Address> ip6list = new ArrayList<IpV6Address>();
	protected ArrayList<NotValidIp> notValidList = new ArrayList<NotValidIp>();
	protected int sourceId;

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
