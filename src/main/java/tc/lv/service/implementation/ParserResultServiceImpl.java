package tc.lv.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.service.ParserResultService;
import tc.lv.utils.ParserResults;

@Service
public class ParserResultServiceImpl implements ParserResultService {

    private static final Logger LOGGER = Logger.getLogger(ParserResultServiceImpl.class);

    @Autowired
    private IpAddressDao ipAddressDao;

    // Update source in DataBAse
    @Transactional
    @Override
    public void save(ParserResults result) throws ParserResultServiceException {

        LOGGER.info("Start updating Data Base");
        try {
            LOGGER.info("Start update IpV4List");
            ipAddressDao.saveList(result.getIpV4List(), result.getSourceId(), IpV4Address.class);
            LOGGER.info("Finish updating IpV4List");

            LOGGER.info("Start update IpV6List");
            ipAddressDao.saveList(result.getIpV6List(), result.getSourceId(), IpV6Address.class);
            LOGGER.info("Finish updating IpV6List");

            LOGGER.info("Start update NotValidList");
            ipAddressDao.saveList(result.getNotValidList(), result.getSourceId(), NotValidIp.class);
            LOGGER.info("Finish updating NotValidList");

            LOGGER.info("Start update WhiteList");
            ipAddressDao.updateStatusList(IpAddress.class);
            LOGGER.info("Finish update WhiteList");

            LOGGER.info("Finish updating Data Base");

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save IP List to Data Base", e);
        }
    }

    @Transactional
    @Override
    public void saveAllSources(List<ParserResults> resultList) throws ParserResultServiceException {

        try {

            for (ParserResults result : resultList) {
                this.save(result);
            }

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save results of all sources", e);
        }
    }
}
