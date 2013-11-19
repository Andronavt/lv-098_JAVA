package tc.lv.service.implementation;

import java.io.FileWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.Location;
import tc.lv.exceptions.JsonException;
import tc.lv.service.JsonService;

@Service
public class JsonServiceImpl implements JsonService {
    private static final Logger LOGGER = Logger.getLogger(JsonServiceImpl.class);

    @Autowired
    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public void createJsonCountryBlackList(String path) throws JsonException {
        JSONObject json = new JSONObject();
        FileWriter file;
        LOGGER.info("!!!!!!!!!!!!11111111111111111111111111111111111111!!");
        try {

            for (Location country : ipAddressDao.findLocationWhiteList(IpQueryEnum.IP)) {
                LOGGER.info("!!!!!!!!!!!!!!!!!SIZE: " + ipAddressDao.findLocationWhiteList(IpQueryEnum.IP).size());
                LOGGER.info("!!!!!!!!!!!!!!!!!COUNTRY NAME: " + country.getCountryCode());
                LOGGER.info("!!!!!!!!!!!!!!!!!COUNTRY IP: "
                        + ipAddressDao.findWhiteListByCountyName(country.getCountryName(), IpQueryEnum.IP).size());

                json.put(country.getCountryCode(),
                        ipAddressDao.findWhiteListByCountyName(country.getCountryName(), IpQueryEnum.IP).size());
            }

            file = new FileWriter(path + "countryJsonWhiteList.txt");
            file.write(json.toString());
            file.flush();
            file.close();

        } catch (Exception e) {
            LOGGER.error("Could not create JSON file", e);
            throw new JsonException("Could not create JSON file", e);

        }
    }

    @Override
    @Transactional
    public void createJsonCountryWhiteList(String path) throws JsonException {
        JSONObject json = new JSONObject();
        FileWriter file;
        LOGGER.info("!!!!!!!!!!!!#######33333333333333333333333!!");
        try {
            LOGGER.info("!!!!!!!!!!!!#######$$$44444444444444444444!!");
            List<Location> loc = ipAddressDao.findLocationWhiteList(IpQueryEnum.IP_V4);
            LOGGER.info("!!!!!!!!!!!!!5555555555555555555555555555!" + loc.size());
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
            throw new JsonException("Could not create JSON file", e);
        }

    }
}
