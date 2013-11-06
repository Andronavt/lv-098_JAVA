package tc.lv.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.utils.Downloader;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResult;
import tc.lv.utils.ParserChaosreignsWL;
import tc.lv.utils.ParserOpenBSD;
import tc.lv.utils.ParserUceprotect;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {

    @Autowired
    private SourceDao sourceDao;

    @Transactional
    @Override
    public List<Source> loadSourceList() {
	return sourceDao.getListOfSources();
    }

    @Transactional
    @Override
    public List<ParserResult> downloadParseData(List<String> sourceNameList,
	    Map<Source, Parser> parserMap) {
	Downloader downloader = new Downloader();
	List<ParserResult> resultList = new ArrayList<ParserResult>();
	File file;
	Set<Source> sourceSet = parserMap.keySet();
	for (String sourceName : sourceNameList) {
	    for (Source source : sourceSet) {
		if (source.getSourceName().equals(sourceName)) {
		    file = downloader.downloadFile(source.getUrl(),
			    source.getDirname());
		    ParserResult tmp = parserMap.get(source).parse(file);
		    tmp.setSourceIs(source.getSourceId());
		    resultList.add(tmp);
		}
	    }
	}
	return resultList;
    }

    @Override
    public Map<Source, Parser> createParserMap(List<Source> sourceList) {
	Map<Source, Parser> parserMap = new HashMap<Source, Parser>();
	for(Source source: sourceList){
	    Class parserClass = Class.forName(source.getParserName());
	    Parser parser = (Parser)parserClass.newInstance();
	    parserMap.put(source, parser);
	}
	return parserMap;
    }
}
