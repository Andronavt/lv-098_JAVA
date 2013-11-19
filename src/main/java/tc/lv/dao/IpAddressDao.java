package tc.lv.dao;

import java.util.List;

import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.IpAddress;
import tc.lv.domain.Location;

public interface IpAddressDao {

    <T extends IpAddress> List<? extends IpAddress> findBlackList(int from, int count, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findBlackList(IpQueryEnum myType);

    <T extends IpAddress> T findByAddress(String address, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findListBySource(int sourceId, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findUnDefList(IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findWhiteList(int from, int count, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findWhiteList(IpQueryEnum myType);

    void removeFromBlackList(IpAddress address, IpQueryEnum myType);

    void removeFromWhiteList(IpAddress address, IpQueryEnum myType);

    void save(IpAddress address);

    void saveList(List<? extends IpAddress> list, int sourceId, IpQueryEnum myType);

    void updateWhiteList(IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCountyName(String contryName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCountyName(String contryName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCityName(String cityName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCityName(String cityName, IpQueryEnum myType);

    <T> List<Location> findLocationWhiteList(IpQueryEnum myType);

    <T> List<Location> findLocationBlackList(IpQueryEnum myType);

}
