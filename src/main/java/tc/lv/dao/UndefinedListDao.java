package tc.lv.dao;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface UndefinedListDao {

	Collection<IpV4Address> loadIpV4List();

	Collection<IpV6Address> loadIpV6List();

}
