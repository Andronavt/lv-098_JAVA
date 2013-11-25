package tc.lv.service;

import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.utils.ParserResults;

public interface GeoIpService {

    public ParserResults updateIpAddresLocation(ParserResults parserResults) throws GeoIpServiceException;
}
