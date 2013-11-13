package tc.lv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Source;
import tc.lv.domain.IpAddress;
import tc.lv.utils.ParserChaosreignsWL;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserOpenBSD;
import tc.lv.utils.ParserUceprotect;

@Repository
public class SourceDaoImpl implements SourceDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Override
	public void save(Source source) {
		entityManager.persist(source);
	}

	@Override
	public Source findByName(String sourceName) {
		Query query = entityManager.createNamedQuery("Source.findByName",
				Source.class);
		query.setParameter("sourceName", sourceName);
		try {
			Source source = (Source) query.getSingleResult();
			return source;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Map<Source, ParserInterface> getMapOfParsers() {
		List<Source> sourceList = entityManager.createQuery("from Source")
				.getResultList();
		Map<Source, ParserInterface> outputMap = new HashMap<Source, ParserInterface>();
		ParserInterface tempPaser = null;
		String checkParser;
		for (Source tempSource : sourceList) {
			checkParser = tempSource.getParser();
			switch (checkParser) {
			case "ParserOpenBSD":
				tempPaser = new ParserOpenBSD();
				break;
			case "ParserUceprotect":
				tempPaser = new ParserUceprotect();
				break;
			case "ParserChaosreignsWL":
				tempPaser = new ParserChaosreignsWL();
				break;
			}
			outputMap.put(tempSource, tempPaser);
		}
		return outputMap;
	}

	@Override
	public List<Source> getAll() {
		Query query = entityManager.createNamedQuery("Source.getAll",
				Source.class);
		return query.getResultList();
	}

	@Override
	public void delete(Source source) {
	    Query query = entityManager.createNamedQuery("Source.findByName",
			Source.class).setParameter("sourceName", source);
		Source tempSource = (Source) query.getSingleResult();
		for (IpAddress address : tempSource.getIpSet()) {
		    address.getSourceSet().remove(tempSource);
		    if(address.getSourceSet().size()==0)
		    {
			entityManager.remove(address);
		    }
		}
		tempSource.getIpSet().clear();
		entityManager.remove(tempSource);
	}

}
