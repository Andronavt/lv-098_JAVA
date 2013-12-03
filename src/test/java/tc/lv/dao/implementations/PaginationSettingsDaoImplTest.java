package tc.lv.dao.implementations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.PaginationSettingsDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class PaginationSettingsDaoImplTest {

	@Autowired
	protected PaginationSettingsDao paginationSettingsDao;


	@Before
	public void dataSetup() {
	}

	@Test
	public void findAllPaginationSettings() {		
		 assertEquals(4, paginationSettingsDao.findAll().size());
	}

}
