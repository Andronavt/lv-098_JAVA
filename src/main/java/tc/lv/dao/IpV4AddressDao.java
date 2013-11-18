package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV4Address;

public interface IpV4AddressDao {

    IpV4Address findByAddress(String address);

    List<IpV4Address> findBlackList();

    List<IpV4Address> findBlackList(int from, int count);

    List<IpV4Address> findListBySource(int sourceId);

    List<IpV4Address> findWhiteList();

    List<IpV4Address> findWhiteList(int from, int count);

    void removeFromBlackList(IpV4Address address);

    void removeFromWhiteList(IpV4Address address);

    void save(IpV4Address address);

    IpV4Address update(IpV4Address address);

}
