package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

public interface SourceDownloaderService {
	
    	public List<Source> loadSourceList();
    	
    	public Map <Source, ParserInterface> createParserMap(List<Source> sourceList);
	
	public List <ParserResults> downloadParseData(List<String> sourceNameList, Map <Source, ParserInterface> parserMap);
	
}
