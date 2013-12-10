package tc.lv.service.implementation;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.JsonServiceException;
import tc.lv.service.JsonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class JsonServiceImplTest {
    private static final String PATH = System.getenv("LV098_JAVA")
	    + "/src/main/webapp/resources/js/jVectorMap/";
    private static final String FILE_NAME = "jsonTest.js";
    private static final Class<? extends IpAddress> ALL_IP_ADDRESSES = IpAddress.class;
    private static final boolean BLACK_LIST = false;

    @Autowired
    JsonService jsonService;

    @Test
    public void createJsonForCountryMapTest() throws JsonServiceException {
	jsonService.createJsonForCountryMap(PATH, FILE_NAME, ALL_IP_ADDRESSES,
		BLACK_LIST);
	boolean ifExist = false;
	for (String fileName : new File(PATH).list()) {
	    if (fileName.equals(FILE_NAME))
		ifExist = true;
	}
	Assert.assertTrue(ifExist);
    }
}
