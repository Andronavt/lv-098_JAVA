package tc.lv.dao;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.utils.Parser;

public interface SourceDao {

	void save(Source source);

	Source findByName(String sourceName);

	Map<Source, Parser> getMapOfParsers();

	List<Source> getAll();

	void delete(Source source);

}
