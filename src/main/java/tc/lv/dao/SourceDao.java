package tc.lv.dao;

import java.util.List;

import tc.lv.domain.Source;

public interface SourceDao {

	void delete(Source source);

	Source findByName(String sourceName);

	List<Source> getAll();

	// Map<Source, Parser> getMapOfParsers();

	void save(Source source);

}
