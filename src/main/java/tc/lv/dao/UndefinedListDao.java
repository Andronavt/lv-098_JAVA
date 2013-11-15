package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface UndefinedListDao {

	List<IpV4Address> getIpV4List();

	List<IpV6Address> getIpV6List();

}
