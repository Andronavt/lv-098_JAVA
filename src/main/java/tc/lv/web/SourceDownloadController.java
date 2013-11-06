 package tc.lv.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.domain.Source;
import tc.lv.service.SourceDownloaderService;
import tc.lv.service.SourceService;
import tc.lv.utils.AdaptorOpenBSD;
import tc.lv.utils.Downloader;
import tc.lv.utils.ParseStrategy;

@Controller
public class SourceDownloadController {
    private static final Logger loggerInfo = Logger.getLogger("infoLog");
    private static final Logger loggerErr = Logger.getLogger("errorLog");

    @Autowired
    private SourceDownloaderService sourceDownloaderService;
    @Autowired
    private SourceService souService;

    // Getting updateSourcesPag.jsp
    @RequestMapping("/admin/SourcesUpdatePage")
    public String getlistIpV4(Map<String, Object> map) {
	loggerInfo.info("getting secure/TestGetIp4List.jsp");
	map.put("listSource", souService.getListOfSourcess());
	return "admin/SourcesUpdatePage";
    }

    // Updating Sources
    @RequestMapping(value = "/admin/updateSources", method = RequestMethod.POST)
    public @ResponseBody
    String sourceDownloader(
	    @ModelAttribute(value = "sourceName1") String sourceName1,
	    @ModelAttribute(value = "sourceName2") String sourceName2,
	    @ModelAttribute(value = "sourceName3") String sourceName3,
	    Map<String, Object> map) {
	// String name1 = "OpenBSD traplist";
	// String name2 = "Nixspam list";
	// String name3 = "Chaosreigns Whitelist";
	List<String> sourceList = new ArrayList<String>();
	List<String> resultList = new ArrayList<String>();
	sourceList.add(sourceName1);
	sourceList.add(sourceName2);
	sourceList.add(sourceName3);
	for (String name : sourceList) {
	    if (!name.equals("")) {
		try {
		    Source source = sourceDownloaderService
			    .loadSourceByName(name);
		    Downloader downloader = new Downloader();
		    String path = downloader.downloadFile(source.getUrl(),
			    source.getDirname());
		    System.out.println(path);
		    ParseStrategy parser = new ParseStrategy(
			    new AdaptorOpenBSD(path, source.getSourceId()));
		    sourceDownloaderService.updateSource(parser.getParser());
		    resultList.add("Source " + name + " updated !");
		} catch (Exception e) {
		    loggerErr.error(e);
		    resultList.add("Error! Source " + name
			    + " don't updated, because catch exception " + e);
		    continue;
		}
	    }
	}
	return "admin/updateSources";// Need create new jsp-file for view result

    }
}
