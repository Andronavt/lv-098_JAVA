package tc.lv.repo;

import java.util.List;

import tc.lv.domain.dbEntities.IpV4Address;
import tc.lv.domain.dbEntities.IpV6Address;
import tc.lv.domain.dbEntities.NotValidIp;

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

	public void setIpV4Address(String ip, int sourceId);

	public void setIpV6Address(String ip, int sourceId);
}
