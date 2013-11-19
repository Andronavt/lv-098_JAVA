package tc.lv.dao;

public interface IpInterface {

    String findAll();

    String findAllNotValid();

    String findAllValid();

    String findBlackIpByName();

    String findByAddress();

    String findBySource();

    String findUndefinedlist();

    String findWhiteIpByName();

    String findWhitelist();

    String findWhiteOrBlackListByCity();

    String findWhiteOrBlackListByCountry();

    String findLocationWhiteOrBlackList();
}
