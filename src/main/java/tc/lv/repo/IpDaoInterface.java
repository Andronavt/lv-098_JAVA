package tc.lv.repo;

import java.util.List;
import tc.lv.domain.ipClasses.IpAddress;

public interface IpDaoInterface {
	boolean add(IpAddress ipAddress);
	List<IpAddress> getAllIp();
}
