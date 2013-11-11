package tc.lv.dao;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;
import tc.lv.utils.ParserInterface;

public interface SourceDao {

	void create(Source source) throws DBCreateSourceException;

	Source loadByName(String sourceName);
	
	public Map<Source,ParserInterface> getMapOfParsers();

	List<Source> loadAll();

	void delete(String sourceName);

}
