package tc.lv.service;

public interface WhiteListService {
	void deleteIpV4FromWL(String address);
	void deleteIpV6FromWL(String address);
}
