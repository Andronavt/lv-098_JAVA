package tc.lv.dao;

public interface IpInterface {

    String countAll();

    String countStatusList();

    String countStatusIpByCityName();

    String countStatusIpByCountryName();

    String findAll();// not used

    String findAllNotValid();// not used

    String findAllValid();// not used

    String findByAddress();

    String findIpListBySource();

    String findIpListByCity();// ??????????

    String findIpListByCountry();// ???????????

    String findIpByAddress();// ?

    String findStatusList();

    String findStatusListByCity();

    String findStatusListByCountryName();

    String findUndefinedList();

}
