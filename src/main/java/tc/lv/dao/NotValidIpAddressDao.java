package tc.lv.dao;

import java.util.List;

import tc.lv.domain.NotValidIp;

public interface NotValidIpAddressDao {

	List<NotValidIp> loadAll(int sourceId);

}
