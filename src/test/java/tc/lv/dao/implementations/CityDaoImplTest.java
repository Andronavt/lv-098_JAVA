package tc.lv.dao.implementations;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class CityDaoImplTest {

	@Autowired
	protected CityDaoImpl cityDaoImpl;

	protected String[] expectedForWhiteList;

	protected String[] expectedForBlackList;

	@Test
	public void findCityNameListByStatusForWhiteList() {
		expectedForWhiteList = new String[] { "Kyiv", "London", "Manchester" };
		List<String> tempActuals = cityDaoImpl.findCityNameListByStatus(true);
		String[] actuals = new String[tempActuals.size()];
		actuals = tempActuals.toArray(actuals);
		assertArrayEquals(expectedForWhiteList, actuals);
	}

	@Test
	public void findCityNameListByStatusForBlackList() {
		expectedForBlackList = new String[] { "Kyiv", "London", "Lviv",
				"Manchester" };
		List<String> tempActuals = cityDaoImpl.findCityNameListByStatus(false);
		String[] actuals = new String[tempActuals.size()];
		actuals = tempActuals.toArray(actuals);
		assertArrayEquals(expectedForBlackList, actuals);
	}

}
