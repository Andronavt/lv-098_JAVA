package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.utils.ParserResults;

public interface DownloaderDao {

	void saveIpV4List(List<IpV4Address> list, int sourceId);

	void saveIpV6List(List<IpV6Address> list, int sourceId);

	void saveNotValIpList(List<NotValidIp> list, int sourceId);

	void save(ParserResults parser);

	void updateWhiteList();

	void saveList(List<? extends IpAddress> list, int sourceId);

	void updateWhiteList(Class<? extends IpAddress> updateClass);

}
