package tc.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceDao dao;

    @Transactional
    public List<IpV4Address> getFirstIpV4ListFromSource(int sourceId,
	    int start, int end) {
	return dao.getFirstIpV4ListFromSource(sourceId, start, end);
    }

    @Transactional
    public List<IpV6Address> getFirstIpV6ListFromSource(int sourceId,
	    int start, int end) {
	return dao.getFirstIpV6ListFromSource(sourceId, start, end);
    }

    @Transactional
    public List<NotValidIp> getFirstNotValidIpListFromSource(int sourceId,
	    int count) {
	return dao.getFirstNotValidIpListFromSource(sourceId, count);
    }

    @Transactional
    public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
	return dao.getIpV4ListFromSource(sourceId);
    }

    @Transactional
    public List<IpV6Address> getIpV6ListFromSource(int sourceId) {
	return dao.getIpV6ListFromSource(sourceId);
    }

    @Transactional
    public List<NotValidIp> getNotValidIpFromSource(int sourceId) {
	return dao.getNotValidIpFromSource(sourceId);
    }

    @Transactional
    public void setIpV4Address(String ip, int sourceId) {
	dao.setIpV4Address(ip, sourceId);
    }

    @Transactional
    public void setIpV6Address(String ip, int sourceId) {
	dao.setIpV6Address(ip, sourceId);
    }
}
