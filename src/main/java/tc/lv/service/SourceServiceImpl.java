package tc.lv.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.BlackListDao;
import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.dao.WhiteListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;

@Service
public class SourceServiceImpl implements SourceService {

        @Autowired
        private SourceDao sourceDao;
        @Autowired
        private IpV4AddressDao ipV4AddressDao;
        @Autowired
        private IpV6AddressDao ipV6AddressDao;
        @Autowired
        private WhiteListDao whiteListDao;
        @Autowired
        private BlackListDao blackListDao; 
        
        @Transactional
        public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
                return ipV4AddressDao.loadAllIpBySource(sourceId);
        }

        @Transactional
        public void setIpV4AddressToWl(String ip, int sourceId) {
            whiteListDao.saveIpV4(ip);
        }
        
        @Transactional
        public void setIpV4AddressToBl(String ip, int sourceId) {
            blackListDao.saveIpV4(ip);
        }

        @Transactional
        public void setIpV6AddressToWl(String ip, int sourceId) {
                whiteListDao.saveIpV6(ip);
        }
        
        @Transactional
        public void setIpV6AddressToBl(String ip, int sourceId) {
                blackListDao.saveIpV6(ip);
        }

        @Transactional
        public void addNewFeed(String dirname, String listType, double rank,
                        String sourceName) throws DBCreateSourceException {
                Source tempSource = new Source(sourceName, new Date(), rank, dirname, listType);
                
                        sourceDao.create(tempSource);
        }

        @Transactional
        public List<Source> getListOfSourcess() {
                return sourceDao.loadAll();
        }

        @Transactional
        public void deleteFeed(String sourceName) {
                sourceDao.delete(sourceName);
        }
}