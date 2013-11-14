package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpAddressImpl;
import tc.lv.utils.ParserResults;

public interface DownloaderDao {

	void save(ParserResults parser);

	void saveList(List<? extends IpAddressImpl> list, int sourceId);

	void updateWhiteList(Class<? extends IpAddressImpl> updateClass)
			throws InstantiationException, IllegalAccessException;

}
