package tc.lv.service.implementation;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Source;
import tc.lv.exceptions.SourceServiseException;
import tc.lv.service.SourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class SourceServiceImplTest {
    public static final double RANK = 0.5;

    @Autowired
    SourceService sourceService;

    @Test
    public void addNewFeedTest() throws SourceServiseException {
	boolean result = sourceService.addNewFeed(null, "Test",
		"http://test.com", "whiteList", RANK);
	Assert.assertTrue(result);
    }

    @Test
    public void getListOfSourcessTest() throws SourceServiseException {
	List<Source> sourcesList = sourceService.getListOfSourcess();
	Assert.assertNotNull(sourcesList);
    }

    @Test
    public void deleteFeedByNameTest() throws SourceServiseException {
	sourceService.addNewFeed(null, "Test", "http://test.com", "whiteList",
		RANK);
	boolean result = sourceService.deleteFeedByName("Test");
	Assert.assertTrue(result);
    }
}
