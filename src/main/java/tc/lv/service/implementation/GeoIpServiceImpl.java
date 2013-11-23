package tc.lv.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.service.GeoIpService;
import tc.lv.utils.GeoIpUtil;
import tc.lv.utils.ParserResults;

@Service
public class GeoIpServiceImpl implements GeoIpService {
    private static final Logger LOGGER = Logger.getLogger(GeoIpServiceImpl.class);
    private static GeoIpUtil geoIpUtil;

    @Override
    @Transactional
    public List<ParserResults> updateIpAddresLocation(List<ParserResults> resultList) throws GeoIpServiceException {
        LOGGER.info("Start updating locations for Ip-addresses");

        try {
            geoIpUtil = new GeoIpUtil();

            for (ParserResults parserResults : resultList) {
                update(parserResults);
            }

            LOGGER.info("Finish updating locations for Ip-addresses");

        } catch (Exception e) {
            LOGGER.error("Could not update location for IP-addresses", e);
            throw new GeoIpServiceException("Could not update location for IP-addresses", e);

        } finally {
            geoIpUtil.dispose();
        }
        return resultList;
    }

    private void update(ParserResults parserRes) throws GeoIpException {
        for (IpV4Address ipv4 : parserRes.getIpV4List()) {
            geoIpUtil.addCityToIpV4Address(ipv4);

        }

        for (IpV6Address ipv6 : parserRes.getIpV6List()) {
            geoIpUtil.addCityToIpV6Address(ipv6);
        }
    }
}
