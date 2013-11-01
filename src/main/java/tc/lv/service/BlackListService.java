package tc.lv.service;

public interface BlackListService {
	void deleteIpV4FromBL(String address);
	void deleteIpV6FromBL(String address);
}
