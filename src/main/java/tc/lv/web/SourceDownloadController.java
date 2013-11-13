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

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.ParserResultService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

@Controller
public class SourceDownloadController {

    private static final Logger logger = Logger
	    .getLogger(SourceDownloadController.class);

    @Autowired
    private SourceDownloaderService sourceDownloaderService;

    @Autowired
    private ParserResultService parserResultService;

    @Autowired
    private SourceDao sourceDao;

    // Getting updateSourcesPag.jsp
    @RequestMapping("/updateSources")
    public String getlistIpV4(Map<String, Object> map) {
	try {
	    map.put("listSource", sourceDownloaderService.loadSourceList());
	} catch (SourceDownloaderServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
	return "updateSources";
    }

    // // Updating Sources
    // @RequestMapping(value = "/admin/updateSources", method =
    // RequestMethod.POST)
    // public @ResponseBody
    // String sourceDownloader(
    // @ModelAttribute(value = "select") String[] sourceNameArray,
    // Map<String, Object> map) {

    // Updating Sources
    @RequestMapping(value = "/updateSourcesButton", method = RequestMethod.GET)
    public String sourceDownloader(Map<String, Object> map) {
	// ----!!!Test block!!!------
	String name1 = "OpenBSD traplist";
	String name2 = "Nixspam list";
	String name3 = "Chaosreigns Whitelist";
	List<String> sourceNameList = new ArrayList<String>();
	sourceNameList.add(name1);
	sourceNameList.add(name2);
	sourceNameList.add(name3);

	// List<String> sourceNameList = new
	// ArrayList<String>(Arrays.asList(sourceNameArray));
	try {
	    logger.info("Create MAP of sources and Parsers");
	    Map<Source, ParserInterface> parserMap = sourceDao
		    .getMapOfParsers();
	    logger.info("Create MAP of sources and Parsers");
	    List<ParserResults> parserResultList = null;
	    logger.info("Start downloading, parsing and updating Data Base");

	    parserResultList = sourceDownloaderService.downloadParseData(
		    sourceNameList, parserMap);
	    parserResultService.saveAllSources(parserResultList);
	    map.put("Result", "Sources UPDATED!!!");
	    return "updateSources";
	} catch (SourceDownloaderServiceException
		| ParserResultServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}

    }

    @RequestMapping(value = "/updateSources", method = RequestMethod.POST)
    public String updateSource(@ModelAttribute(value = "source") String source,
	    Map<String, Object> map) {
	map.put("Result", source + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	return "updateSources";
    }
}
