package tc.lv.service.implementation;

import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.Location;
import tc.lv.exceptions.JsonServiceException;
import tc.lv.service.JsonService;

public class JsonServiceImpl implements JsonService {
    private static final Logger LOGGER = Logger.getLogger(BlackListServiceImpl.class);

    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public void createJsonCountryWhiteList(String path) throws JsonServiceException {
        JSONObject json = new JSONObject();
        FileWriter file;

        try {
            for (Location country : ipAddressDao.findLocationWhiteList(IpQueryEnum.IP)) {
                json.put(country.getCountryCode(),
                        ipAddressDao.findWhiteListByCountyName(country.getCountryName(), IpQueryEnum.IP).size());
            }

            file = new FileWriter(path + "countryJsonWhiteList.txt");
            file.write(json.toString());
            file.flush();
            file.close();

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);

        }
    }

    @Override
    @Transactional
    public void createJsonCountryBlackList(String path) throws JsonServiceException {
        JSONObject json = new JSONObject();
        FileWriter file;
        try {
            for (Location country : ipAddressDao.findLocationBlackList(IpQueryEnum.IP)) {
                json.put(country.getCountryCode(),
                        ipAddressDao.findBlackListByCountyName(country.getCountryName(), IpQueryEnum.IP).size());
            }

            file = new FileWriter(path + "countryJsonBlackList.txt");
            file.write(json.toString());
            file.flush();
            file.close();

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);
        }
    }
}
