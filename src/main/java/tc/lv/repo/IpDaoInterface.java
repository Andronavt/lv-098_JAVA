package tc.lv.repo;

import java.util.List;

import tc.lv.domain.dbEntities.IpAddress;

public interface IpDaoInterface {
	boolean add(IpAddress ipAddress);
	List<IpAddress> getAllIp();
	boolean addAllIpAddresses(List<IpAddress> inputArray);
}
