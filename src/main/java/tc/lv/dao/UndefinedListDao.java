package tc.lv.dao;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface UndefinedListDao {

	Collection<IpV4Address> getIpV4List();

	Collection<IpV6Address> getIpV6List();

}
