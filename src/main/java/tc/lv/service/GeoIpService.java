package tc.lv.service;

import java.util.List;

import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.utils.ParserResults;

public interface GeoIpService {

    public List<ParserResults> updateIpAddresLocation(List<ParserResults> resultList) throws GeoIpServiceException;
}
