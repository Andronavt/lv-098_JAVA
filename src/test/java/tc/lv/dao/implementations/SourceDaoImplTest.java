package tc.lv.dao.implementations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
	protected List<Source> listSource;

	@Before
	public void dataSetup() {
		source = new Source("test", "testSource", "http://www.local.com",
				"blacklist", 0.5);
		newSource = new Source("test", "testNewSource", "http://www.local.com",
				"blacklist", 0.5);
	}

	@Test
	public void saveSource() {
		if (source.equals(sourceDaoImpl.findByName("testSource"))) {
			fail("SOURCE ALREADY EXIST");
		}
		sourceDaoImpl.save(source);
		assertEquals(source, sourceDaoImpl.findByName("testSource"));
	}

	@Test
	public void deleteSource() {
		saveSource();
		sourceDaoImpl.delete(source);
		assertEquals(null, sourceDaoImpl.findByName("testSource"));
	}

	@Test
	public void updateSource() {
		saveSource();
		sourceDaoImpl.update(newSource);
		assertEquals(newSource, sourceDaoImpl.findByName("testNewSource"));
	}

	@Test
	public void findSourceByName() {
		saveSource();
		assertEquals(source, sourceDaoImpl.findByName("testSource"));
	}

	@Test
	public void findAllSource() {
		assertEquals(5, sourceDaoImpl.findAll().size());
	}

}
