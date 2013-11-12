package tc.lv.service;

import java.util.List;



import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;
import tc.lv.utils.ParserResults;

public interface ParserResultService {

    public void saveAllSources(List<ParserResults> resultList) throws DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void save(ParserResults result) throws DBPersistanceException, DBIllegalArgumentException, DBIllegalStateException, DBException;
}
