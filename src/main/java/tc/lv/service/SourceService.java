package tc.lv.service;

import java.util.List;

import tc.lv.domain.IpV4Address;

public interface SourceService {

	public List<IpV4Address> getIpV4ListFromSource(int sourceId);
}
