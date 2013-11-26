package tc.lv.service.implementation;

import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.lv.dao.CountryDao;
import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.JsonServiceException;
import tc.lv.service.JsonService;

@Service
public class JsonServiceImpl implements JsonService {
    private static final Logger LOGGER = Logger.getLogger(JsonServiceImpl.class);

    @Autowired
    IpAddressDao ipAddressDao;
    @Autowired
    CountryDao countryDao;

    @Override
    public void createJsonForCountryMap(String path, String fileName, Class<? extends IpAddress> ipType,
            boolean status) throws JsonServiceException {
        JSONObject json = new JSONObject();
        FileWriter file;
        try {
            LOGGER.info("Start creating JSON-file for " + (status ? "White" : "Black") + "Map.");

            for (String code : countryDao.findCountryCodeListByStatus(status, ipType)) {
                long l = ipAddressDao.countStatusIpByCountryCode(status, code, ipType);
                LOGGER.info("country code: " + code + ", ip count: " + l);
                json.put(code, l);
            }
            file = new FileWriter(path + fileName);
            file.write("var array =");
            file.write(json.toString());
            file.write(";");
            file.close();
            LOGGER.info("Finish creating JSON-file for " + (status ? "White" : "Black") + "Map.");

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);

        }
    }

}
