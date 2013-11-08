package tc.lv.service;

import java.util.Date;
import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;

public interface SourceService{

	public List<IpV4Address> getIpV4ListFromSource(int sourceId);

	public void setIpV4AddressToWl(String ip, int sourceId);
	public void setIpV4AddressToBl(String ip, int sourceId);

	public void setIpV6AddressToWl(String ip, int sourceId);
	public void setIpV6AddressToBl(String ip, int sourceId);

		public void addNewFeed(String dirname, String listType, double rank,
			String sourceName) throws DBCreateSourceException;

	public void deleteFeed(String sourceName);

	public List<Source> getListOfSourcess();

}
