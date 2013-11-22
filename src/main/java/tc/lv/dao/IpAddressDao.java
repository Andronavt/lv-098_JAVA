package tc.lv.dao;

import java.util.List;

import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.DBException;

public interface IpAddressDao {

    Integer countAll(Class<? extends IpAddress> ipType) throws DBException;

    Integer countStatusIp(boolean status, Class<? extends IpAddress> ipType) throws DBException;

    Integer countStatusIpByCityName(boolean status, String cityName, Class<? extends IpAddress> ipType)
            throws DBException;

    Integer countStatusIpByCountryName(boolean status, String countryName, Class<? extends IpAddress> ipType)
            throws DBException;

    void deleteIp(IpAddress address);

    <T extends IpAddress> T findByAddress(String address, Class<? extends IpAddress> ipType) throws DBException;

    List<City> findCityListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException;

    List<Country> findCountryListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException;

    <T extends IpAddress> List<T> findIpListBySource(int sourceId, Class<? extends IpAddress> ipType)
            throws DBException;

    <T extends IpAddress> List<T> findStatusList(boolean status, int from, int count,
            Class<? extends IpAddress> ipType) throws DBException;

    <T extends IpAddress> List<T> findStatusListByCity(boolean status, int from, int count, String cityName,
            Class<? extends IpAddress> ipType) throws DBException;

    <T extends IpAddress> List<T> findStatusListByCountry(boolean status, int from, int count, String countryName,
            Class<? extends IpAddress> ipType) throws DBException;

    <T extends IpAddress> List<T> findUndefList(Class<? extends IpAddress> ipType) throws DBException;

    void removeIpFromStatusList(boolean status, IpAddress address);

    void save(IpAddress address);

    void saveList(List<? extends IpAddress> list, int sourceId, Class<? extends IpAddress> ipType)
            throws DBException;

    void updateStatusList(Class<? extends IpAddress> ipType) throws DBException;

    String findCountryCodeByCountryName(String country, Class<? extends IpAddress> ipType) throws DBException;

}
