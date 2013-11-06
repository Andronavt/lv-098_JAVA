package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResult;

public interface SourceDownloaderService {
	
    	public List<Source> loadSourceList();
    	
    	public Map <Source, Parser> createParserMap(List<Source> sourceList);
	
	public List <ParserResult> downloadParseData(List<String> sourceNameList, Map <Source, Parser> parserMap);
	
}
