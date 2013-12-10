package tc.lv.dao.implementations;

import static org.junit.Assert.assertTrue;

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
	public void findCountryCodeListByStatus() throws DBException{
		System.out.println(countryDaoImpl.findCountryCodeListByStatus(true));
	}

}