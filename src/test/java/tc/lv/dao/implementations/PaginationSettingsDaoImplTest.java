package tc.lv.dao.implementations;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

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

	private static final int PAGINATION_SETTINGS_SIZE = 4;

	@Test
	public void findAllPaginationSettings() {

		PaginationSettings paginationSettings = new PaginationSettings();
		expected = new PaginationSettings[PAGINATION_SETTINGS_SIZE];

		int tempCountPerPages = 10;
		for (int i = 0, j = 1; i < PAGINATION_SETTINGS_SIZE; i++, j++) {
			paginationSettings.setId(j);
			paginationSettings.setIpsPerPage(tempCountPerPages);
			expected[i] = paginationSettings;
			paginationSettings = new PaginationSettings();
			tempCountPerPages += 10;
		}

		List<PaginationSettings> tempActuals = paginationSettingsDao.findAll();
		PaginationSettings[] actuals = new PaginationSettings[tempActuals
				.size()];
		actuals = tempActuals.toArray(actuals);
		assertArrayEquals(expected, actuals);
	}

}
