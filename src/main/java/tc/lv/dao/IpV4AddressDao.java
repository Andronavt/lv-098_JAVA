package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV4Address;

public interface IpV4AddressDao {

	List<IpV4Address> loadAll(int sourceId);

}
