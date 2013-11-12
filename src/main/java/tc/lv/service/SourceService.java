package tc.lv.service;

import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

public interface SourceService {

    public List<IpV4Address> getIpV4ListFromSource(int sourceId) throws DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;

      public void addNewFeed(String dirname, String listType, double rank,
	    String sourceName) throws DBCreateSourceException, DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void deleteFeed(String sourceName) throws DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;

    public List<Source> getListOfSourcess() throws DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;

}
