package tc.lv.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.utils.Downloader;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {
    private static final Logger logger = Logger
	    .getLogger(SourceDownloaderServiceImpl.class);
    @Autowired
    private SourceDao sourceDao;

    @Transactional
    @Override
    public List<ParserResults> downloadParseData(List<String> sourceNameList,
	    Map<Source, ParserInterface> parserMap)
	    throws SourceDownloaderServiceException {
	try {
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
	} catch (Exception e) {
	    logger.error(e);
	    throw new SourceDownloaderServiceException(
		    "Data havent been downloaded ", e);
	}
    }

    @Transactional
    @Override
    public List<Source> loadSourceList()
	    throws SourceDownloaderServiceException {
	try {
	    return sourceDao.getAll();
	} catch (Exception e) {
	    logger.error(e);
	    throw new SourceDownloaderServiceException(
		    "Entity manager Exception", e);
	}
    }

    @Transactional
    @Override
    public Map<Source, ParserInterface> createParserMap(List<Source> sourceList)
	    throws SourceDownloaderServiceException {
	Map<Source, ParserInterface> parserMap = new HashMap<Source, ParserInterface>();
	for (Source source : sourceList) {
	    if (source.getParser() != null) {
		Class parserClass;
		try {
		    parserClass = Class.forName(source.getParser());
		} catch (Exception e) {
		    logger.error(e);
		    throw new SourceDownloaderServiceException(
			    "Can't find Class of Parser!", e);
		}
		ParserInterface parser = null;
		try {
		    parser = (ParserInterface) parserClass.newInstance();
		} catch (Exception e) {
		    logger.error(e);
		    throw new SourceDownloaderServiceException(
			    "class of Parser cannot be instantiated!", e);
		}
		parserMap.put(source, parser);
	    }
	}
	return parserMap;
    }

    // Don't use now
    @Transactional
    @Override
    public Map<Source, ParserInterface> getMapOfParsers()
	    throws SourceDownloaderServiceException {
	Map<Source, ParserInterface> mapOfParsers;
	try {
	    mapOfParsers = sourceDao.getMapOfParsers();
	} catch (Exception e) {
	    logger.error(e);
	    throw new SourceDownloaderServiceException(
		    "Entity manager Exception", e);
	}
	return mapOfParsers;
    }

}
