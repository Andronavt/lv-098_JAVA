package tc.lv.dao.implementations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Transactional
public class ParseDaoImplTest {

	@Autowired
	protected ParserDaoImpl parserDaoImpl;

	
	/*
	 * magic
	 */
	@Test
	public void findAll() {
		
	}

}
