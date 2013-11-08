package tc.lv.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface WhiteListService {
    public void deleteIpV4(String address);

    public void deleteIpV6(String address);

    public void saveIpV4(String address);

    public void saveIpV6(String address);

    public Collection<IpV4Address> loadIpV4List();

    public Collection<IpV6Address> loadIpV6List();
}
