package tc.lv.service.implementation;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class LocationServiceImplTest {
    public final static int FROM = 1;
    public final static int COUNT = 10;

    @Autowired
    LocationService locationService;

    @Test
    public void countStatusIpByCityName() throws LocationServiceException {
	long ipCount = locationService.countStatusIpByCityName("Taipei",
		"AllIp", "blackList");
	Assert.assertNotNull(ipCount);
    }

    @Test
    public void countStatusIpByCountryName() throws LocationServiceException {
	long ipCount = locationService.countStatusIpByCountryName("Taiwan",
		"AllIp", "blackList");
	Assert.assertNotNull(ipCount);
    }

    @Test
    public void findCityListByStatus() throws LocationServiceException {
	List<String> cityList = locationService.findCityListByStatus("AllIp",
		"blackList");
	Assert.assertNotEquals(0, cityList.size());
    }

    @Test
    public void findCountryListByStatus() throws LocationServiceException {
	List<String> countryList = locationService.findCountryListByStatus(
		"AllIp", "blackList");
	Assert.assertNotEquals(0, countryList.size());
    }

    @Test
    public void findStatusListByCity() throws LocationServiceException {
	List<IpAddress> ipList = locationService.findStatusListByCity(FROM,
		COUNT, "Taipei", "AllIp", "blackList");
	Assert.assertEquals(COUNT, ipList.size());
    }

    @Test
    public void findStatusListByCountry() throws LocationServiceException {
	List<IpAddress> ipList = locationService.findStatusListByCountry(FROM,
		COUNT, "Taiwan", "AllIp", "blackList");
	Assert.assertEquals(COUNT, ipList.size());
    }

}
