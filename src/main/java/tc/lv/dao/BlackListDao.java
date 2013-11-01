package tc.lv.dao;

public interface BlackListDao {
	void deleteIpV4FromBL(String address);
	void deleteIpV6FromBL(String address);
}
