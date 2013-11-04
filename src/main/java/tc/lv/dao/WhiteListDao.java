package tc.lv.dao;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;


public interface WhiteListDao {
	void deleteIpV4FromWL(String address);
	void deleteIpV6FromWL(String address);
	
	void addIpV4toWL(String address);
	void addIpV6toWL(String address);
	
	Collection<IpV4Address> getIpV4ListFromWL();
	Collection<IpV6Address> getIpV6ListFromWL();
}
