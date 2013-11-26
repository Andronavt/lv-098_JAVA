package tc.lv.web;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.exceptions.JsonServiceException;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.GeoIpService;
import tc.lv.service.JsonService;
import tc.lv.service.ParserResultService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResults;

@Controller
public class SourceDownloadController {
    private static final String PATH = System.getenv("LV098_JAVA") + "/src/main/webapp/resources/js/jVectorMap/";
    private static final String FILE_JSON_WHITE_LIST = "countryJsonWhiteList.js";
    private static final String FILE_JSON_BLACK_LIST = "countryJsonBlackList.js";
    private static final Class<? extends IpAddress> ALL_IP_ADDRESSES = IpAddress.class;
    private static final boolean WHITE_LIST = true;
    private static final boolean BLACK_LIST = false;

    private static final Logger LOGGER = Logger.getLogger(SourceDownloadController.class);

    @Autowired
    private SourceDownloaderService sourceDownloaderService;

    @Autowired
    private GeoIpService geoIpService;

    @Autowired
    private ParserResultService parserResultService;

    @Autowired
    private JsonService jsonService;

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
    public String sourceDownloader(@ModelAttribute("source") String[] sourceNameArray, Map<String, Object> map) {
        List<String> sourceNameList = Arrays.asList(sourceNameArray);
        LOGGER.info("Start updating Sources.");
        try {
            // loading sources list
            List<Source> sourceList = sourceDownloaderService.loadSourceList();

            // Creating Mapping with sources and parsers
            Map<Source, Parser> parserMap = sourceDownloaderService.createParserMap(sourceList);
            for (String sourceName : sourceNameList) {
                LOGGER.info("Start updating SOURCE:" + sourceName);

                // downloading and parsering files from sources
                ParserResults parserResult = sourceDownloaderService.downloadParseAndUpdateData(sourceName,
                        parserMap);

                // adding locations from GeoIP
                ParserResults parserResultWithLocations = geoIpService.updateIpAddresLocation(parserResult);

                // saving to data base
                parserResultService.save(parserResultWithLocations);

            }
            // Updating status list
            sourceDownloaderService.updateStatusList();

            // Creating JSON files for White and Black Maps
            jsonService.createJsonForCountryMap(PATH, FILE_JSON_WHITE_LIST, ALL_IP_ADDRESSES, WHITE_LIST);
            jsonService.createJsonForCountryMap(PATH, FILE_JSON_BLACK_LIST, ALL_IP_ADDRESSES, BLACK_LIST);

            LOGGER.info("Finish updating Sources.");

            map.put("successMsg", "Updated :)");
            return "result";

        } catch (SourceDownloaderServiceException | GeoIpServiceException | ParserResultServiceException
                | JsonServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }

    }
}
