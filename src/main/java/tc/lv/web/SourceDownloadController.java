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

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.DownloadClassNotFoundException;
import tc.lv.exceptions.DownloadFileNotFoundException;
import tc.lv.exceptions.DownloadIOException;
import tc.lv.exceptions.DownloadIllegalAccessException;
import tc.lv.exceptions.DownloadInstantiationException;
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
	@RequestMapping("/admin/SourcesUpdatePage")
	public String getlistIpV4(Map<String, Object> map) {
		loggerInfo.info("getting secure/TestGetIp4List.jsp");
		map.put("listSource", sourceDownloaderService.loadSourceList());
		return "admin/SourcesUpdatePage";
	}

	// // Updating Sources
	// @RequestMapping(value = "/admin/updateSources", method =
	// RequestMethod.POST)
	// public @ResponseBody
	// String sourceDownloader(
	// @ModelAttribute(value = "select") String[] sourceNameArray,
	// Map<String, Object> map) {

	// Updating Sources
	@RequestMapping("/updateSources")
	public void sourceDownloader() {

		// ----!!!Test block!!!------
		// String name1 = "OpenBSD traplist";
		// String name2 = "Nixspam list";
		String name3 = "Chaosreigns Whitelist";
		List<String> sourceNameList = new ArrayList<String>();
		// sourceNameList.add(name1);
		// sourceNameList.add(name2);
		sourceNameList.add(name3);

		// List<String> sourceNameList = new
		// ArrayList<String>(Arrays.asList(sourceNameArray));
		Map<Source, ParserInterface> parserMap = sourceDao.getMapOfParsers();
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
		try {
			parserResultList = sourceDownloaderService.downloadParseData(
					sourceNameList, parserMap);
			parserResultService.saveAllSources(parserResultList);
		} catch (DownloadFileNotFoundException e) {
			loggerErr.error(e);
		} catch (DownloadIOException e) {
			loggerErr.error(e);
		} catch (DownloadMalformedURLException e) {
			loggerErr.error(e);
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
		// return "admin/updateSourcesResult";// Need create new jsp-file for
		// view
		// result

	}
}
