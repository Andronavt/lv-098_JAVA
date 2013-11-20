package tc.lv.service.implementation;

import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.exceptions.JsonServiceException;
import tc.lv.service.JsonService;

@Service
public class JsonServiceImpl implements JsonService {
    private static final Logger LOGGER = Logger.getLogger(JsonServiceImpl.class);

    @Autowired
    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public void createJsonCountryWhiteList(String path) throws JsonServiceException {
        JSONObject json = new JSONObject();
        FileWriter file;

        try {
            LOGGER.info("SSTART JSON IN TRY!!!!!!!!!!!!!!!!!!!");
            LOGGER.info("SIZE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                    + ipAddressDao.findCountriesWhiteList(IpQueryEnum.IP).size());
            LOGGER.info(path);
            file = new FileWriter(path + "countryJsonWhiteList.txt");
            for (String country : ipAddressDao.findCountriesWhiteList(IpQueryEnum.IP)) {
                json.put(country, ipAddressDao.findWhiteListByCountyName(country, IpQueryEnum.IP).size());
            }
            LOGGER.info("BEFORE STOP !!!!!!!!!!!!!!!!!!!");
            file.write(json.toString());
            LOGGER.info("STOP !!!!!!!!!!!!!!!!!!!");
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
            LOGGER.info("SSTART JSON IN TRY!!!!!!!!!!!!!!!!!!!");
            LOGGER.info("SIZE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                    + ipAddressDao.findCountriesBlackList(IpQueryEnum.IP).size());
            LOGGER.info(path);
            file = new FileWriter(path + "countryJsonBlackList.txt");
            for (String country : ipAddressDao.findCountriesBlackList(IpQueryEnum.IP)) {
                json.put(country, ipAddressDao.findBlackListByCountryName(country, IpQueryEnum.IP).size());
            }
            LOGGER.info("BEFORE STOP !!!!!!!!!!!!!!!!!!!");
            file.write(json.toString());
            LOGGER.info("STOP !!!!!!!!!!!!!!!!!!!");
            file.close();

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonServiceException("Could not create JSON file", e);
        }
    }
}
