package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV6Address;

public interface IpV6AddressDao {

	List<IpV6Address> loadAll(int sourceId);

}
