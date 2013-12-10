package tc.lv.dao.implementations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.DBException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class IpAddressDaoImplTest {

	@Autowired
	protected IpAddressDaoImpl ipAddressDaoImpl;

	/*
	 * countStatusIp()
	 */

	@Test
	public void countStatusIpFromWhiteListAsIpV4Type() throws DBException {

		long expecteds = 2;
		long actual = ipAddressDaoImpl.countStatusIp(true, IpV4Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpFromBlackListAsIpV4Type() throws DBException {

		long expecteds = 3;
		long actual = ipAddressDaoImpl.countStatusIp(false, IpV4Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpFromWhiteListAsIpV6Type() throws DBException {

		long expecteds = 1;
		long actual = ipAddressDaoImpl.countStatusIp(true, IpV6Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpFromBlackListAsIpV6Type() throws DBException {

		long expecteds = 3;
		long actual = ipAddressDaoImpl.countStatusIp(false, IpV6Address.class);
		assertEquals(expecteds, actual);
	}

	/*
	 * countStatusIpByCityName()
	 */

	@Test
	public void countStatusIpByCityNameFromWhiteListAndIpV4Type()
			throws DBException {

		long expecteds = 1;
		long actual = ipAddressDaoImpl.countStatusIpByCityName(true,
				"Manchester", IpV4Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpByCityNameFromBlackListAndIpV4Type()
			throws DBException {

		long expecteds = 1;
		long actual = ipAddressDaoImpl.countStatusIpByCityName(false,
				"London", IpV4Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpByCityNameFromWhiteListAndIpV6Type()
			throws DBException {

		long expecteds = 1;
		long actual = ipAddressDaoImpl.countStatusIpByCityName(true, "London",
				IpV6Address.class);
		assertEquals(expecteds, actual);
	}

	@Test
	public void countStatusIpByCityNameFromBlackListAndIpV6Type()
			throws DBException {

		long expecteds = 1;
		long actual = ipAddressDaoImpl.countStatusIpByCityName(false,
				"Manchester", IpV6Address.class);
		assertEquals(expecteds, actual);
	}

	/*
	 * countStatusIpByCountryName()
	 */

	@Test
	public void countStatusIpByCountryNameFromWhiteListAndIpV4Type()
			throws DBException {

		long expected = 1;
		long actual = ipAddressDaoImpl.countStatusIpByCountryCode(true, "EN",
				IpV4Address.class);
		System.out.println(actual);
		assertEquals(expected, actual);	
	}

}
