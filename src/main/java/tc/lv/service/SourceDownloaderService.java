package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

public interface SourceDownloaderService {

	public List<Source> loadSourceList()
			throws SourceDownloaderServiceException;

	public Map<Source, ParserInterface> createParserMap(List<Source> sourceList)
			throws SourceDownloaderServiceException;

	public List<ParserResults> downloadParseData(List<String> sourceNameList,
			Map<Source, ParserInterface> parserMap)
			throws SourceDownloaderServiceException;

	public Map<Source, ParserInterface> getMapOfParsers()
			throws SourceDownloaderServiceException;

}
