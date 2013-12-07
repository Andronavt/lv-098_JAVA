package tc.lv.dao.implementations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.exceptions.DBException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class CityDaoImplTest {

	@Autowired
	protected CityDaoImpl cityDaoImpl;

	protected City city;

	protected Country country;

	protected String[] expectedForWhiteList;

	protected String[] expectedForBlackList;

	@Before
	public void dataSetup() {
		country = new Country("Nigeria", "NG");
		city = new City("Zimbabue", country);
	}

	@Test
	public void saveCity() {
		cityDaoImpl.save(city);
		boolean condition = cityDaoImpl.isCityExists(city);
		assertTrue(condition);
	}

	@Test
	public void updateCity() {
		cityDaoImpl.save(city);
		Country newCountry = new Country("Nigeria", "NI");
		City newCity = new City("Zimbabue", newCountry);
		cityDaoImpl.update(newCity);
		boolean condition = cityDaoImpl.isCityExists(newCity);
		assertTrue(condition);
	}

	@Test
	public void isCityExists() {
		cityDaoImpl.creatCityMap();
		Country country = new Country("Ukraine", "UA");
		City city = new City("Kyiv", country);
		boolean condition = cityDaoImpl.isCityExists(city);			
		assertTrue("Not found",condition);
	}
	
	@Test
	public void creatCityMap(){
		cityDaoImpl.creatCityMap();		
	}

	@Test
	public void findCityNameListByStatusForWhiteList() throws DBException {
		expectedForWhiteList = new String[] { "Kyiv", "London", "Manchester" };
		List<String> tempActuals = cityDaoImpl.findCityNameListByStatus(true);
		String[] actuals = new String[tempActuals.size()];
		actuals = tempActuals.toArray(actuals);
		assertArrayEquals(expectedForWhiteList, actuals);
	}

	@Test
	public void findCityNameListByStatusForBlackList() throws DBException {
		expectedForBlackList = new String[] { "Kyiv", "London", "Lviv",
				"Manchester" };
		List<String> tempActuals = cityDaoImpl.findCityNameListByStatus(false);
		String[] actuals = new String[tempActuals.size()];
		actuals = tempActuals.toArray(actuals);
		assertArrayEquals(expectedForBlackList, actuals);
	}

}
