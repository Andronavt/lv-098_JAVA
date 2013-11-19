package tc.lv.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.implementations.IpQueryEnum;
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
            ipAddressDao.saveList(result.getIpV4List(), result.getSourceId(), IpQueryEnum.IP_V4);
            ipAddressDao.saveList(result.getIpV6List(), result.getSourceId(), IpQueryEnum.IP_V6);
            ipAddressDao.saveList(result.getNotValidList(), result.getSourceId(), IpQueryEnum.IP_NOT_VALID);
            LOGGER.info("Finish updating Data Base");

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save results of parser", e);
        }
    }

    @Transactional
    @Override
    public void saveAllSources(List<ParserResults> resultList) throws ParserResultServiceException {

        try {

            for (ParserResults result : resultList) {
                this.save(result);
            }
            LOGGER.info("Start update WhiteList");
            ipAddressDao.updateWhiteList(IpQueryEnum.IP);
            LOGGER.info("Finish update WhiteList");

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save results of all sources", e);
        }
    }
}
