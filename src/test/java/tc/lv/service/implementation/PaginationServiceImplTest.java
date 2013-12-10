package tc.lv.service.implementation;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.PaginationSettings;
import tc.lv.service.PaginationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class PaginationServiceImplTest {
    public static final int COUNT = 4;
    @Autowired
    PaginationService paginationService;

    @Test
    public void loadPagesTest() {
	List<PaginationSettings> pageList = paginationService.loadPages();
	Assert.assertEquals(COUNT, pageList.size());
    }
}
