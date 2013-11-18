package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.Source;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.ParserResultService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResults;

@Controller
public class SourceDownloadController {

    private static final Logger LOGGER = Logger.getLogger(SourceDownloadController.class);

    @Autowired
    private SourceDownloaderService sourceDownloaderService;

    @Autowired
    private ParserResultService parserResultService;

    // Getting updateSourcesPag.jsp
    @RequestMapping("admin_updateSources")
    public String getlistIpV4(Map<String, Object> map) {
        try {
            map.put("listSource", sourceDownloaderService.loadSourceList());

        } catch (SourceDownloaderServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "admin_updateSources";
    }

    // Updating Sources
    @RequestMapping(value = "admin_updateSourcesButton", method = RequestMethod.POST)
    public String sourceDownloader(@ModelAttribute("source") String sourceName, Map<String, Object> map) {
        List<String> sourceNameList = new ArrayList<String>();
        LOGGER.info("SOURCE:" + sourceName);
        sourceNameList.add(sourceName);

        try {
            LOGGER.info("Create MAP of sources and Parsers");

            List<Source> sourceList = sourceDownloaderService.loadSourceList();

            Map<Source, Parser> parserMap = sourceDownloaderService.createParserMap(sourceList);

            List<ParserResults> parserResultList = null;

            LOGGER.info("Start downloading, parsing and updating Data Base");

            parserResultList = sourceDownloaderService.downloadParseAndUpdateData(sourceNameList, parserMap);

            parserResultService.saveAllSources(parserResultList);

            LOGGER.info("Finish downloading, parsing and updating Data Base");

            map.put("successMsg", "Sourc " + sourceName + " UPDATED!!!");
            return "result";

        } catch (SourceDownloaderServiceException | ParserResultServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }

    }
}
