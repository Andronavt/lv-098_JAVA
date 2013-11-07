package tc.lv.utils;

import java.util.ArrayList;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public class ParserResults {
	public ArrayList<IpV4Address> ip4List = new ArrayList<IpV4Address>();
	public ArrayList<IpV6Address> ip6List = new ArrayList<IpV6Address>();
	public ArrayList<NotValidIp> notValidList = new ArrayList<NotValidIp>();
	public int sourceId;

	public ArrayList<IpV4Address> getIp4list() {
		return ip4List;
	}

	public void setIp4List(ArrayList<IpV4Address> ip4list) {
		this.ip4List = ip4list;
	}

	public ArrayList<IpV6Address> getIp6list() {
		return ip6List;
	}

	public void setIp6List(ArrayList<IpV6Address> ip6list) {
		this.ip6List = ip6list;
	}

	public ArrayList<NotValidIp> getNotValidList() {
		return notValidList;
	}

	public void setNotValidList(ArrayList<NotValidIp> notValidList) {
		this.notValidList = notValidList;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

}
