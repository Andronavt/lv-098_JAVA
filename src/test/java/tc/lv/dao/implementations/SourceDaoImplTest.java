package tc.lv.dao.implementations;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Source;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class SourceDaoImplTest {

	@Autowired
	protected SourceDaoImpl sourceDaoImpl;

	protected Source source;

	protected Source newSource;

	protected Source[] expected;

	@Before
	public void dataSetup() {
		source = new Source("test", "testSource", "http://www.local.com",
				"blacklist", 0.5);
	}

	@Test
	public void saveSource() {
		sourceDaoImpl.save(source);
		Source expected = source;
		Source actual = sourceDaoImpl.findByName("testSource");
		assertEquals(expected, actual);
	}

	@Test
	public void deleteSource() {
		sourceDaoImpl.save(source);
		sourceDaoImpl.delete(source);
		Source actual = sourceDaoImpl.findByName("testSource");
		assertEquals(null, actual);
	}

	@Test
	public void updateSource() {
		newSource = new Source("test", "testNewSource", "http://www.local.com",
				"blacklist", 0.5);
		sourceDaoImpl.save(source);
		sourceDaoImpl.update(newSource);
		Source expected = newSource;
		Source actual = sourceDaoImpl.findByName("testNewSource");
		assertEquals(expected, actual);
	}

	@Test
	public void findSourceByName() {
		sourceDaoImpl.save(source);
		Source expected = source;
		Source actual = sourceDaoImpl.findByName("testSource");
		assertEquals(expected, actual);
	}

	@Test
	public void findSourceById() {
		Source expected = sourceDaoImpl.findByName("OpenBSD traplist");
		Source actual = sourceDaoImpl.findByID(1);
		assertEquals(expected, actual);
	}

	@Test
	public void findAllSource() {
		expected = new Source[] {
				new Source("tc.lv.utils.ParserOpenBSD", "OpenBSD traplist",
						"http://www.openbsd.org/spamd/traplist.gz",
						"blacklist", 0.7),
				new Source(
						"tc.lv.utils.ParserUceprotect",
						"Nixspam list",
						"http://www.dnsbl.manitu.net/download/nixspam-ip.dump.gz",
						"blacklist", 0.6),
				new Source("tc.lv.utils.ParserChaosreignsWL",
						"Chaosreigns Whitelist",
						"http://www.chaosreigns.com/iprep/iprep.txt",
						"whitelist", 0.1) };

		List<Source> tempActual = sourceDaoImpl.findAll();
		Source[] actuals = new Source[tempActual.size()];
		actuals = tempActual.toArray(actuals);
		assertArrayEquals(expected, actuals);
	}

}