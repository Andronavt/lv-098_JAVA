package tc.lv.service;

import java.util.Date;
import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;

public interface SourceService{

	public List<IpV4Address> getIpV4ListFromSource(int sourceId);

	public void setIpV4Address(String ip, int sourceId);

	public void setIpV6Address(String ip, int sourceId);

	public void addNewFeed(String sourceName, Date sourceDateAdded,
		    Double rank, String dirname, String listType);

	public void deleteFeed(String sourceName);

	public List<Source> getListOfSourcess();

}
