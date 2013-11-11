package tc.lv.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
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
import tc.lv.utils.Downloader;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {
    private static final Logger logger = Logger.getLogger("errorLog");
    @Autowired
    private SourceDao sourceDao;

    @Transactional
    @Override
    public List<ParserResults> downloadParseData(List<String> sourceNameList,
	    Map<Source, ParserInterface> parserMap)
	    throws DownloadFileNotFoundException, DownloadIOException,
	    DownloadMalformedURLException {
	Downloader downloader = new Downloader();
	List<ParserResults> resultList = new ArrayList<ParserResults>();
	File file;
	Set<Source> sourceSet = parserMap.keySet();
	for (String sourceName : sourceNameList) {
	    for (Source source : sourceSet) {
		if (source.getSourceName().equals(sourceName)) {
		    file = downloader.downloadFile(source.getUrl(),
			    source.getDirname());
		    ParserResults tmp = parserMap.get(source).parse(file);
		    tmp.setSourceId(source.getSourceId());
		    tmp.printLists();
		    System.out.println(resultList.add(tmp));
		}
	    }
	}
	return resultList;
    }

    @Transactional
    @Override
    public Map<Source, ParserInterface> getMapOfParsers() throws DBException {
	Map<Source, ParserInterface> mapOfParsers;
	try {
	    mapOfParsers = sourceDao.getMapOfParsers();
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e){
	    logger.error(e);
	    throw new DBIllegalArgumentException("method getMapOfParsers has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e){
	    logger.error(e);
	    throw new DBIllegalStateException("method getMapOfParsers has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e){
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
	return mapOfParsers;
    }
    //Don't use now
    @Transactional
    @Override
    public List<Source> loadSourceList() {
	return sourceDao.loadAll();
    }
    //Don't use now
    @Transactional
    @Override
    public Map<Source, ParserInterface> createParserMap(List<Source> sourceList)
	    throws DownloadClassNotFoundException,
	    DownloadInstantiationException, DownloadIllegalAccessException {
	Map<Source, ParserInterface> parserMap = new HashMap<Source, ParserInterface>();
	for (Source source : sourceList) {
	    Class parserClass;
	    try {
		parserClass = Class.forName(source.getParser());
	    } catch (ClassNotFoundException e) {
		logger.error(e);
		throw new DownloadClassNotFoundException(
			"Can't find Class of Parser!");
	    }
	    ParserInterface parser = null;
	    try {
		parser = (ParserInterface) parserClass.newInstance();
	    } catch (InstantiationException e) {
		logger.error(e);
		throw new DownloadInstantiationException(
			"class of Parser cannot be instantiated!");
	    } catch (IllegalAccessException e) {
		logger.error(e);
		throw new DownloadIllegalAccessException(
			"currently executing method does not have access to the definition of the specified class Parser");
	    }
	    parserMap.put(source, parser);
	}
	return parserMap;
    }

}
