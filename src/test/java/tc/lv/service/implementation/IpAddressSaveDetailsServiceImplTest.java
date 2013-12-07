package tc.lv.service.implementation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.service.IpAddressSaveDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class IpAddressSaveDetailsServiceImplTest {

    @Autowired
    private IpAddressSaveDetailsService ipAddressSaveDetailsService;

    @Test
    public void getDetailsTestIpV4() throws IpAddressServiceException {
	IpAddress ipAddress = ipAddressSaveDetailsService.getDetails(
		"216.240.132.150", "whiteList");
	Assert.assertEquals("Los Angeles", ipAddress.getCity().getCityName());
    }

    @Test
    public void getDetailsTestIpV6() throws IpAddressServiceException {
	IpAddress ipAddress = ipAddressSaveDetailsService.getDetails(
		"2001:02e8:0646", "whiteList");
	Assert.assertEquals("None", ipAddress.getCity().getCityName());
    }

    @Test
    public void getSourceByStatusTestWhite() throws IpAddressServiceException {
	Source source = ipAddressSaveDetailsService
		.getSourceByStatus("whiteList");
	Assert.assertEquals("Admin Whitelist", source.getSourceName());

    }

    @Test
    public void getSourceByStatusTestBlack() throws IpAddressServiceException {
	Source source = ipAddressSaveDetailsService
		.getSourceByStatus("blackList");
	Assert.assertEquals("Admin Blacklist", source.getSourceName());

    }

}
