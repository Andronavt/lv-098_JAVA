package tc.lv.utils;

import tc.lv.dao.SourceDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.Source;

public class IpVersionUtil {

	private static SourceDao sourceDao;
	private static final String ADMIN_WHITE_LIST = "Admin Whitelist";
	private static final String ADMIN_BLACK_LIST = "Admin Blacklist";

	public static boolean checkWhiteList(IpAddress ipAddress) {
		return ipAddress.getStatus();
	}

	public static Class<? extends IpAddress> ipVersion(String ipType) {
		if (ipType.equals("ipv4"))
			return IpV4Address.class;
		if (ipType.equals("ipv6"))
			return IpV6Address.class;

		return IpAddress.class;
	}

	public static boolean isWhiteIpAddress(String status) {
		return (status.equals("whiteList") ? true : false);
	}
}
