package tc.lv.service.implementation;

import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.exceptions.JsonServiceException;
import tc.lv.service.JsonService;


public class JsonServiceImpl implements JsonService {
    private static final Logger LOGGER = Logger.getLogger(BlackListServiceImpl.class);

  
    GeoIpDao geoIpDao;

    @Override
    @Transactional
    public void createJsonCountryWhiteList(String path) throws JsonServiceException {
        JSONObject json = new JSONObject();

        for (String country : geoIpDao.loadCountryWhiteList()) {
            json.put(country, geoIpDao.loadIpWhiteListByCountry(country).size());
        }

        FileWriter file = new FileWriter(path + "countryJsonWhiteList.txt");

        try {
            file.write(json.toString());

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);

        } finally {
            file.flush();
            file.close();
        }
    }

    @Override
    @Transactional
    public void createJsonCountryBlackList(String path) throws JsonServiceException {
        JSONObject json = new JSONObject();

        for (String country : geoIpDao.loadCountryBlackList()) {
            json.put(country, geoIpDao.loadIpBlackListByCountry(country).size());
        }

        FileWriter file = new FileWriter(path + "countryJsonBlackList.txt");

        try {
            file.write(json.toString());

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);

        } finally {
            file.flush();
            file.close();
        }
    }
}
