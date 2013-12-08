package tc.lv.utils;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public class IpVersionUtil {

    private static final String WHITE_LIST = "White list"; // "whiteList"

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
        return (status.equals(WHITE_LIST) ? true : false);
    }
}
