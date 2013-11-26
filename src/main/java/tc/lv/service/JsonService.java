package tc.lv.service;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.JsonServiceException;

public interface JsonService {

    public void createJsonForCountryMap(String path, String fileName, Class<? extends IpAddress> ipType,
            boolean status) throws JsonServiceException;
}
