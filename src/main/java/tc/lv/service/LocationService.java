package tc.lv.service;

import java.util.List;

import tc.lv.domain.IpAddress;

public interface LocationService {

    public List<IpAddress> loadWhiteListOfCityByRange(int i1, int i2);

    public List<IpAddress> loadBlackListOfCityByRange(int i1, int i2);

    public List<IpAddress> loadWhiteListOfCountryByRange(int i1, int i2);

    public List<IpAddress> loadBlackListOfCountryByRange(int i1, int i2);
}
