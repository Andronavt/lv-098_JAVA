package tc.lv.dao;

public interface IpInterface {

    String countAll();

    String countStatusList();

    String countStatusIpByCityName();

    String countStatusIpByCountryCode();

    String countStatusIpByCountryName();

    String findAll();

    String findByAddress();

    String findIpListBySource();

    String findStatusList();

    String findStatusListByCity();

    String findStatusListByCountryName();

    String findUndefinedList();

}
