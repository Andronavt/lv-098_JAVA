package tc.lv.dao;


public interface WhiteListDao {
	void deleteIpV4FromWL(String address);
	void deleteIpV6FromWL(String address);
}
