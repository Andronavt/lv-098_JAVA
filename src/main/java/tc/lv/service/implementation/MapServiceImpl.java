package tc.lv.service.implementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.service.LocationService;

public class MapServiceImpl implements LocationService {

    @Override
    @Transactional
    public List<IpAddress> loadBlackListOfCityByRange(int i1, int i2) {
        try {
            return null;
        } catch (Exception e) {
            
        }
        
    }

    @Override
    @Transactional
    public List<IpAddress> loadBlackListOfCountryByRange(int i1, int i2) {
        return null;
    }

    @Override
    @Transactional
    public List<IpAddress> loadWhiteListOfCityByRange(int i1, int i2) {
        return null;
    }

    @Override
    @Transactional
    public List<IpAddress> loadWhiteListOfCountryByRange(int i1, int i2) {
        return null;
    }
}
