package tc.lv.domain;

public interface IpAddress {

	String getGetAllNotValid();

	String getGetAllValid();

	String getGetAll();

	String getGetBySource();

	String getFindByAddress();

	String getGetWhitelist();

	String getGetUndefinedlist();

	String getFindWhiteIpByName();

	String getFindBlackIpByName();
}
