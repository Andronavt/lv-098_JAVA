package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;
import tc.lv.exceptions.DownloadClassNotFoundException;
import tc.lv.exceptions.DownloadFileNotFoundException;
import tc.lv.exceptions.DownloadIOException;
import tc.lv.exceptions.DownloadIllegalAccessException;
import tc.lv.exceptions.DownloadInstantiationException;
import tc.lv.exceptions.DownloadMalformedURLException;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

public interface SourceDownloaderService {

    public List<Source> loadSourceList();

    public Map<Source, ParserInterface> createParserMap(List<Source> sourceList)
	    throws DownloadClassNotFoundException,
	    DownloadInstantiationException, DownloadIllegalAccessException;

    public List<ParserResults> downloadParseData(List<String> sourceNameList,
	    Map<Source, ParserInterface> parserMap)
	    throws DownloadFileNotFoundException, DownloadIOException,
	    DownloadMalformedURLException;

    public Map<Source, ParserInterface> getMapOfParsers()
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;

}
