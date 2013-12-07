package tc.lv.dao.implementations;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.PaginationSettingsDao;
import tc.lv.domain.PaginationSettings;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class PaginationSettingsDaoImplTest {

	@Autowired
	protected PaginationSettingsDao paginationSettingsDao;

	protected PaginationSettings[] expected;

	@Before
	public void dataSetup() {
		PaginationSettings a = new PaginationSettings();
		expected = new PaginationSettings[4];
		a.setId(1);
		a.setIpsPerPage(10);
		expected[0] = a;
		// PaginationSettings b = new PaginationSettings();
		a = new PaginationSettings();
		a.setId(2);
		a.setIpsPerPage(20);
		expected[1] = a;
		// PaginationSettings c = new PaginationSettings();
		a = new PaginationSettings();
		a.setId(3);
		a.setIpsPerPage(30);
		expected[2] = a;
		// PaginationSettings d = new PaginationSettings();
		a = new PaginationSettings();
		a.setId(4);
		a.setIpsPerPage(40);
		expected[3] = a;
		// expected = new PaginationSettings[] { a, b, c, d };
	}

	@Test
	public void findAllPaginationSettings() {
		List<PaginationSettings> tempActuals = paginationSettingsDao.findAll();
		System.out.println(tempActuals);
		PaginationSettings[] actuals = new PaginationSettings[tempActuals
				.size()];
		actuals = tempActuals.toArray(actuals);
		System.out.println(actuals[0].getId() + " "+ actuals[0].getIpsPerPage());
		System.out.println(actuals[1].getId() + " "+ actuals[1].getIpsPerPage());
		System.out.println(actuals[2].getId() + " "+ actuals[2].getIpsPerPage());
		System.out.println(actuals[3].getId() + " "+ actuals[3].getIpsPerPage());
		System.out.println("-------------------------------------------------");
		System.out.println(expected[0].getId() + " "+ expected[0].getIpsPerPage());
		System.out.println(expected[1].getId() + " "+ expected[1].getIpsPerPage());
		System.out.println(expected[2].getId() + " "+ expected[2].getIpsPerPage());
		System.out.println(expected[3].getId() + " "+ expected[3].getIpsPerPage());
		assertArrayEquals(expected, actuals);
	}

}
