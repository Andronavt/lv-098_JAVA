package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.utils.Parser;

public interface SourceDao {

	public List<IpV4Address> getIpV4ListFromSource(int sourceId);

	public List<IpV6Address> getIpV6ListFromSource(int sourceId);

	public List<NotValidIp> getNotValidIpFromSource(int sourceId);

	public List<IpV4Address> getFirstIpV4ListFromSource(int sourceId,
			int start, int end);

	public List<IpV6Address> getFirstIpV6ListFromSource(int sourceId,
			int start, int end);

	public List<NotValidIp> getFirstNotValidIpListFromSource(int sourceId,
			int count);

	public void addNewFeed(String typeofList, String rank,
			String sourceName, String url);

	public void setIpV4Address(String ip, int sourceId);

	public void setIpV6Address(String ip, int sourceId);

	public void deleteFeed(String sourceName);

	public List<Source> getListOfSources();

	public void updateSourceIpV4List(List<IpV4Address> list, int sourceId);

	public void updateSourceIpV6List(List<IpV6Address> list, int sourceId);

	public void updateSourceNotValIpList(List<NotValidIp> list, int sourceId);
	
	public void updateSourceIpList(Parser parser);
	
}
