package tc.lv.dao;

public interface IpInterface {

    String countAll();

    String countStatusList();

    String countStatusIpByCity();

    String countStatusIpByCountry();

    String findAll();// not used

    String findAllNotValid();// not used

    String findAllValid();// not used

    String findByAddress();

    String findIpListBySource();

    String findCityListByStatus();

    String findCountryListByStatus();

    String findIpListByCity();// ??????????

    String findIpListByCountry();// ???????????

    String findIpByAddress();// ?

    String findStatusList();

    String findStatusListByCity();

    String findStatusListByCountry();

    String findUndefinedList();

    String findCountryCodeByCountryName();
}
