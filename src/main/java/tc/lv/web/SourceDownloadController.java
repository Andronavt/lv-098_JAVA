package tc.lv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.domain.Source;
import tc.lv.service.SourceDownloaderService;
import tc.lv.service.SourceDownloaderServiceImpl;
import tc.lv.utils.AdaptorOpenBSD;
import tc.lv.utils.Downloader;
import tc.lv.utils.ParseStrategy;
import tc.lv.utils.Parser;

@Controller
public class SourceDownloadController {
	
	@Autowired
	private SourceDownloaderService sourceDownloaderService;

	@RequestMapping("/updateSources")
	public void sourceDownloader() {

		String name1 = "OpenBSD traplist";
		String name2 = "Nixspam list";
		String name3 = "Chaosreigns Whitelist";
		Source source = sourceDownloaderService.loadSourceByName(name3);
		Downloader downloader = new Downloader();
		String path = downloader.downloadFile(source.getUrl(),
				source.getDirname());
		System.out.println(path);
		ParseStrategy parser = new ParseStrategy(new AdaptorOpenBSD(path,
				source.getSourceId()));
		sourceDownloaderService.updateSource(parser.getParser());
	}

}
