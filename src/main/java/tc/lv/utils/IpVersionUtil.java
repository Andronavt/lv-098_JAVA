package tc.lv.utils;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public class IpVersionUtil {

	public static boolean checkWhiteList(IpAddress ipAddress) {
		return ipAddress.getStatus();
	}

	public static Class<? extends IpAddress> makeIpType(int ipType) {
		if (ipType == 0)
			return IpV4Address.class;
		if (ipType == 1)
			return IpV6Address.class;
		return IpAddress.class;
	}

	public static boolean makeStatus(int status) {
		return (status == 1 ? true : false);
	}

}
