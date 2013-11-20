package tc.lv.dao;

public interface IpInterface {

    String findAll();

    String findAllNotValid();

    String findAllValid();

    String findBlackIpByName();

    String findByAddress();

    String findBySource();

    String findUndefinedlist();

    String findWhiteOrBlackIpByName();

    String findWhiteOrBlackList();

    String findWhiteOrBlackListByCity();

    String findIpListByCity();

    String findWhiteOrBlackListByCountry();

    String findIpListByCountry();

    String findCitiesWhiteOrBlackList();

    String findCountriesWhiteOrBlackList();

    String countAll();

    String countWhiteOrBlackList();

    String countWhiteOrBlackListByCountry();

}
