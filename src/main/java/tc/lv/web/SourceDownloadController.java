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
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.domain.Source;
import tc.lv.service.ParserResultService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResult;

@Controller
public class SourceDownloadController {
    private static final Logger loggerInfo = Logger.getLogger("infoLog");
    private static final Logger loggerErr = Logger.getLogger("errorLog");

    @Autowired
    private SourceDownloaderService sourceDownloaderService;

    @Autowired
    private ParserResultService parserResultService;

    // Getting updateSourcesPag.jsp
    @RequestMapping("/admin/SourcesUpdatePage")
    public String getlistIpV4(Map<String, Object> map) {
	loggerInfo.info("getting secure/TestGetIp4List.jsp");
	map.put("listSource", sourceDownloaderService.loadSourceList());
	return "admin/SourcesUpdatePage";
    }

    // Updating Sources
    @RequestMapping(value = "/admin/updateSources", method = RequestMethod.POST)
    public @ResponseBody
    String sourceDownloader(
	    @ModelAttribute(value = "select") String[] sourceNameArray,
	    Map<String, Object> map) {
	
	//----!!!Test block!!!------
	String name1 = "OpenBSD traplist";
	String name2 = "Nixspam list";
	String name3 = "Chaosreigns Whitelist";
	List<String> sourceNameList = new ArrayList<String>();
	sourceNameList.add(name1);
	sourceNameList.add(name2);
	sourceNameList.add(name3);
		
	//List<String> sourceNameList = new ArrayList<String>(Arrays.asList(sourceNameArray));
	List<Source> sourceList = sourceDownloaderService.loadSourceList();
	Map<Source, Parser> parserMap = sourceDownloaderService.createParserMap(sourceList);
	List<ParserResult> parserResultList = sourceDownloaderService.downloadParseData(sourceNameList, parserMap);
	parserResultService.saveAllSources(parserResultList);
	

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
	return "admin/updateSourcesResult";// Need create new jsp-file for view
					   // result

    }
}
