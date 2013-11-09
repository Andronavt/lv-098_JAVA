package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.DownloadFileNotFoundException;
import tc.lv.exceptions.DownloadIOException;
import tc.lv.exceptions.DownloadMalformedURLException;
import tc.lv.service.ParserResultService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.ParserInterface;
import tc.lv.utils.ParserResults;

@Controller
public class SourceDownloadController {
    private static final Logger loggerInfo = Logger.getLogger("infoLog");
    private static final Logger loggerErr = Logger.getLogger("errorLog");

    @Autowired
    private SourceDownloaderService sourceDownloaderService;

    @Autowired
    private ParserResultService parserResultService;

    @Autowired
    private SourceDao sourceDao;

    // Getting updateSourcesPag.jsp
    @RequestMapping("/updateSources")
    public String getlistIpV4(Map<String, Object> map) {
	map.put("listSource", sourceDownloaderService.loadSourceList());
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
	// String name1 = "OpenBSD traplist";
	 String name2 = "Nixspam list";
	//String name3 = "Chaosreigns Whitelist";
	List<String> sourceNameList = new ArrayList<String>();
	// sourceNameList.add(name1);
	// sourceNameList.add(name2);
	sourceNameList.add(name2);

	// List<String> sourceNameList = new
	// ArrayList<String>(Arrays.asList(sourceNameArray));
	loggerInfo.info("Create MAP of sources and Parsers");
	Map<Source, ParserInterface> parserMap = sourceDao.getMapOfParsers();
	loggerInfo.info("Create MAP of sources and Parsers");
	// try {
	// parserMap = sourceDownloaderService.createParserMap(sourceList);
	// } catch (DownloadClassNotFoundException e) {
	// loggerErr.error(e);
	// } catch (DownloadInstantiationException e) {
	// loggerErr.error(e);
	// } catch (DownloadIllegalAccessException e) {
	// loggerErr.error(e);
	// }
	List<ParserResults> parserResultList = null;
	loggerInfo.info("Start downloading, parsing and updating Data Base");
	try {
	    parserResultList = sourceDownloaderService.downloadParseData(
		    sourceNameList, parserMap);
	    parserResultService.saveAllSources(parserResultList);
	} catch (DownloadFileNotFoundException e) {
	    loggerErr.error(e);
	    System.err.println(e);
	} catch (DownloadIOException e) {
	    loggerErr.error(e);
	    System.err.println(e);
	} catch (DownloadMalformedURLException e) {
	    loggerErr.error(e);
	    System.err.println(e);
	}

	// for (String name : sourceNameList) {
	// if (!name.equals("")) {
	// try {
	// Source source = sourceDownloaderService
	// .loadSourceByName(name);
	// Downloader downloader = new Downloader();
	// String path = downloader.downloadFile(source.getUrl(),
	// source.getDirname());
	// System.out.println(path);
	// ParseStrategy parser = new ParseStrategy(
	// new ParserOpenBSD(path, source.getSourceId()));
	// sourceDownloaderService.updateSource(parser.getParser());
	// resultList.add("Source " + name + " updated !");
	// } catch (Exception e) {
	// loggerErr.error(e);
	// resultList.add("Error! Source " + name
	// + " don't updated, because catch exception " + e);
	// continue;
	// }
	// }
	// }
	// map.put("resultList", resultList);
	map.put("Result", "UPDATED!!!");
	return "updateSources";// Need create new jsp-file for
	// view
	// result

    }
}
