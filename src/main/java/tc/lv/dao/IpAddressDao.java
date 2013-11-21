package tc.lv.dao;

import java.util.List;

import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.IpAddress;

public interface IpAddressDao {

    <T extends IpAddress> List<? extends IpAddress> findBlackList(int from, int count, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findBlackList(IpQueryEnum myType);

    <T extends IpAddress> T findByAddress(String address, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findListBySource(int sourceId, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findUnDefList(IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findWhiteList(int from, int count, IpQueryEnum myType);

    <T extends IpAddress> List<? extends IpAddress> findWhiteList(IpQueryEnum myType);

    void removeFromBlackList(IpAddress address);

    void removeFromWhiteList(IpAddress address);

    void deleteIp(IpAddress address);

    void save(IpAddress address);

    void saveList(List<? extends IpAddress> list, int sourceId, IpQueryEnum myType);

    void updateWhiteList(IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCountyName(String countryName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCountryName(String countryName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCityName(String cityName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCityName(String cityName, IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCountryName(int from, int count, String countryName,
            IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCountryName(int from, int count, String countryName,
            IpQueryEnum myType);

    <T extends IpAddress> List<T> findWhiteListByCityName(int from, int count, String countryName,
            IpQueryEnum myType);

    <T extends IpAddress> List<T> findBlackListByCityName(int from, int count, String countryName,
            IpQueryEnum myType);

    List<String> findCountriesWhiteList(IpQueryEnum myType);

    List<String> findCountriesBlackList(IpQueryEnum myType);

    Integer countAll(IpQueryEnum myType);

    Integer countWhiteIp(IpQueryEnum myType);

    Integer countBlackIp(IpQueryEnum myType);

    Integer countWhiteListByCountyName(String countryName, IpQueryEnum myType);

    Integer countBlackListByCountyName(String countryName, IpQueryEnum myType);
}
