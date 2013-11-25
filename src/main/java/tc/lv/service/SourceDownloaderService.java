package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.Source;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResults;

public interface SourceDownloaderService {

    public List<Source> loadSourceList() throws SourceDownloaderServiceException;

    public Map<Source, Parser> createParserMap(List<Source> sourceList) throws SourceDownloaderServiceException;

    public ParserResults downloadParseAndUpdateData(String sourceName, Map<Source, Parser> parserMap)
            throws SourceDownloaderServiceException;

    public void updateStatusList() throws SourceDownloaderServiceException;
}
