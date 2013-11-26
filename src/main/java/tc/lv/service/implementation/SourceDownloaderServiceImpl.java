package tc.lv.service.implementation;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.Downloader;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResults;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {
    private static final Logger LOGGER = Logger.getLogger(SourceDownloaderServiceImpl.class);
    private static final String PROJECT_DIR = System.getenv("LV098_JAVA");
    private static final String ADMIN_WHITE_LIST = "Admin Whitelist";
    private static final String ADMIN_BLACK_LIST = "Admin Blacklist";

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private IpAddressDao ipAddressDao;

    @Transactional
    @Override
    public ParserResults downloadParseAndUpdateData(String sourceName, Map<Source, Parser> parserMap)
            throws SourceDownloaderServiceException {
        LOGGER.info("Start downloading, parsing and updating sources.");
        try {
            Downloader downloader = new Downloader();

            ParserResults result = null;

            File file;

            Set<Source> sourceSet = parserMap.keySet();
            for (Source source : sourceSet) {
                if (source.getSourceName().equals(sourceName)) {
                    file = downloader.downloadFile(source.getUrl(), PROJECT_DIR + source.getDirname());
                    result = parserMap.get(source).parse(file);
                    result.setSourceId(source.getSourceId());
                    break;
                }
            }

            LOGGER.info("Finish downloading, parsing and updating sources.");
            return result;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceDownloaderServiceException("Data didn't downloaded ", e);
        }
    }

    @Transactional
    @Override
    public List<Source> loadSourceList() throws SourceDownloaderServiceException {
        List<Source> sourcesList;
        try {
            sourcesList = sourceDao.findAll();
            sourcesList.remove(sourceDao.findByName(ADMIN_BLACK_LIST));
            sourcesList.remove(sourceDao.findByName(ADMIN_WHITE_LIST));
            return sourcesList;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceDownloaderServiceException("Could not load list of sources", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Map<Source, Parser> createParserMap(List<Source> sourceList) throws SourceDownloaderServiceException {
        LOGGER.info("Start creating Map of Sources and Parsers.");
        Map<Source, Parser> parserMap = new HashMap<Source, Parser>();

        for (Source source : sourceList) {

            if (source.getParser() != null) {
                Class<Parser> parserClass;

                try {
                    parserClass = (Class<Parser>) Class.forName(source.getParser());

                } catch (Exception e) {
                    LOGGER.error(e);
                    throw new SourceDownloaderServiceException("Can't find Class of Parser!", e);
                }

                Parser parser = null;

                try {
                    parser = (Parser) parserClass.newInstance();

                } catch (Exception e) {
                    LOGGER.error(e);
                    throw new SourceDownloaderServiceException("class of Parser cannot be instantiated!", e);
                }

                parserMap.put(source, parser);
            }
        }
        LOGGER.info("Finish creating Map of Sources and Parsers.");
        return parserMap;
    }

    @Transactional
    @Override
    public void updateStatusList() throws SourceDownloaderServiceException {
        LOGGER.info("Start update WhiteList");
        try {
            ipAddressDao.updateStatusList(IpAddress.class);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceDownloaderServiceException("class of Parser cannot be instantiated!", e);
        }
        LOGGER.info("Finish update WhiteList");
    }

}
