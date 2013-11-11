package tc.lv.dao;

import java.util.List;

import tc.lv.domain.NotValidIp;

public interface NotValidIpAddressDao {

	List<NotValidIp> loadAllIpBySource(int sourceId);
	List<NotValidIp> loadNotValidIpListByRange(int from, int count);
	List<NotValidIp> loadAllNotValidIpList();

}
