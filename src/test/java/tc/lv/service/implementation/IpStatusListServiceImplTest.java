package tc.lv.service.implementation;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpStatusListServiceException;
import tc.lv.service.IpStatusListService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class IpStatusListServiceImplTest {
    public final static int FROM = 1;
    public final static int COUNT = 10;
    @Autowired
    IpStatusListService ipStatusListService;

    @Test
    public void findIpListTest() throws IpStatusListServiceException {
	Collection<IpAddress> ipList = ipStatusListService.findIpList(FROM,
		COUNT, "AllIp", "whiteList");
	Assert.assertEquals(COUNT, ipList.size());
    }

    @Test
    public void findIpCountTest() throws IpStatusListServiceException {
	Long ipCount = ipStatusListService.findIpCount("AllIp", "whiteList");
	Assert.assertNotNull(ipCount);
    }

}
