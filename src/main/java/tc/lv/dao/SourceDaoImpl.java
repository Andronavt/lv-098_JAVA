


package tc.lv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;
import tc.lv.utils.ParserChaosreignsWL;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserOpenBSD;
import tc.lv.utils.ParserUceprotect;

@Repository
public class SourceDaoImpl implements SourceDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    @Override
    public void create(Source source) throws DBCreateSourceException {
	Query query = entityManager.createNamedQuery("Source.loadByName",
		Source.class);
	Source temp = (Source) query.setParameter("sourceName",
		source.getSourceName()).getSingleResult();
	if (temp == null) {
	    entityManager.persist(source);
	} else {
	    throw new DBCreateSourceException("That source is already exists");
	}
    }

    @Override
    public Source loadByName(String sourceName) {
	Query query = entityManager.createNamedQuery("Source.loadByName",
		Source.class);
	query.setParameter("sourceName", sourceName);
	return (Source) query.getSingleResult();
    }
    
    public Map<Source,ParserInterface> getMapOfParsers(){
    	List<Source> sourceList = entityManager.createQuery("from Source").getResultList();
    	Map<Source,ParserInterface> outputMap = new HashMap<Source, ParserInterface>();
    	ParserInterface tempPaser = null;
    	String checkParser;
    	for(Source tempSource:sourceList){
    		checkParser=tempSource.getParser();
    		switch(checkParser){
				case "ParserOpenBSD" :
					tempPaser = new ParserOpenBSD();break;
				case "ParserUceprotect" :
					tempPaser = new ParserUceprotect();break;
				case "ParserChaosreignsWL" :
					tempPaser = new ParserChaosreignsWL();break;
    		}
    		outputMap.put(tempSource, tempPaser);
    	}
    	return outputMap;
    }

    @Override
    public List<Source> loadAll() {
	return entityManager.createNamedQuery("Source.loadAll", Source.class)
		.getResultList();
    }

    @Override
    public void delete(String sourceName) {
	sourceName = sourceName.trim();
	Query query = entityManager.createNamedQuery("Source.loadByName",
		Source.class).setParameter("sourceName", sourceName);
	Source tempSource = (Source) query.getSingleResult();
	entityManager.remove(tempSource);
    }

}
