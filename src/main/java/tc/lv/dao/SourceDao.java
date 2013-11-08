package tc.lv.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;

public interface SourceDao {

	void creat(String sourceName, Date sourceDateAdded, Double rank,
			String dirname, String listType);

	void creat(String sourceName, String url, Date sourceDateAdded,
			Double rank, String dirname, String listType, Date updated,
			String parser, Collection<IpAddress> ipSet);

	Source loadByName(String sourceName);

	List<Source> loadAll();

	void delete(String sourceName);

}
