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

import tc.lv.domain.Country;
import tc.lv.exceptions.DBException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class CountryDaoImplTest {

	@Autowired
	protected CountryDaoImpl countryDaoImpl;

	protected Country country;

	@Before
	public void dataSetup() {
		country = new Country("Test", "t");
	}

	@Test
	public void saveCountry() {

		countryDaoImpl.save(country);

		boolean condition = countryDaoImpl.isCountryExists(country);

		assertTrue(condition);
	}

	@Test
	public void updateCountry() {

		countryDaoImpl.save(country);

		Country newCountry = new Country("Test", "NT");

		countryDaoImpl.update(newCountry);

		boolean condition = countryDaoImpl.isCountryExists(newCountry);

		assertTrue(condition);
	}

	@Test
	public void isCountryExists() {

		countryDaoImpl.creatCountryMap();

		Country country = new Country("Ukraine", "UA");

		boolean condition = countryDaoImpl.isCountryExists(country);

		assertTrue(condition);
	}

	@Test
	public void findCountryCodeListByWhiteList() throws DBException {

		String[] expecteds = new String[] { "EN", "RU", "UA" };

		List<String> tempActuals = countryDaoImpl
				.findCountryCodeListByStatus(true);

		String[] actuals = new String[tempActuals.size()];

		actuals = tempActuals.toArray(actuals);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void findCountryCodeListByBlackList() throws DBException {

		String[] expecteds = new String[] { "EN", "UA" };

		List<String> tempActuals = countryDaoImpl
				.findCountryCodeListByStatus(false);

		String[] actuals = new String[tempActuals.size()];

		actuals = tempActuals.toArray(actuals);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void findCountryCodeByCountryName() throws DBException {

		String[] expecteds = new String[] { "UA", "EN" };

		String uaElement = countryDaoImpl
				.findCountryCodeByCountryName("Ukraine");

		String enElement = countryDaoImpl
				.findCountryCodeByCountryName("England");

		String[] actuals = new String[] { uaElement, enElement };

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void findCountryNameListByWhiteList() throws DBException {

		String[] expecteds = new String[] { "England", "Russian Federation",
				"Ukraine" };

		List<String> tempActuals = countryDaoImpl
				.findCountryNameListByStatus(true);

		String[] actuals = new String[tempActuals.size()];

		actuals = tempActuals.toArray(actuals);

		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void findCountryNameListByBlackList() throws DBException {

		String[] expecteds = new String[] { "England", "Ukraine" };

		List<String> tempActuals = countryDaoImpl
				.findCountryNameListByStatus(false);

		String[] actuals = new String[tempActuals.size()];

		actuals = tempActuals.toArray(actuals);

		assertArrayEquals(expecteds, actuals);
	}

}