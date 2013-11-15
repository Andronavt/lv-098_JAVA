package tc.lv.dao;

import java.util.List;

import tc.lv.domain.Source;

public interface SourceDao {

	Source findByName(String sourceName);

	List<Source> getAll();

	void save(Source source);

	Source update(Source source);

	void delete(Source source);

}
