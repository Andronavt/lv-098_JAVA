package tc.lv.service.implementation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.domain.Source;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.IpAddressService;
import tc.lv.service.SourceDownloaderService;
import tc.lv.utils.DownloadManager;
import tc.lv.utils.Downloader;
import tc.lv.utils.DownloaderInterface;
import tc.lv.utils.IpValidator;
import tc.lv.utils.JarClassLoader;
import tc.lv.utils.Parser;
import tc.lv.utils.ParserResults;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {
	private static final Logger LOGGER = Logger
			.getLogger(SourceDownloaderServiceImpl.class);
	private static final String PROJECT_DIR = System.getenv("LV098_JAVA");
	private static final String ADMIN_WHITE_LIST = "Admin Whitelist";
	private static final String ADMIN_BLACK_LIST = "Admin Blacklist";

	@Autowired
	private SourceDao sourceDao;

	@Autowired
	private IpAddressService ipAddressService;

	@Override
	@Transactional
	public ParserResults downloadParseAndUpdateData(String sourceName)
			throws SourceDownloaderServiceException {
		LOGGER.info("Start downloading, parsing and updating sources.");
		try {
			DownloadManager downloadManager = new DownloadManager();
			JarClassLoader classLoader = new JarClassLoader();
			ParserResults result = new ParserResults();
			File file;
			Source source = sourceDao.findByName(sourceName);
			Class<? extends DownloaderInterface> downloader = classLoader.findClassByName("tc/lv/utils/"
					+ source.getUnzipper().getName(), PROJECT_DIR
					+ "/src/main/resources/plugins/unzippers/"
					+ source.getUnzipper().getName() + ".jar");
			Class parser = classLoader.findClassByName("tc/lv/utils/"
					+ source.getParser().getName(), PROJECT_DIR
					+ "/src/main/resources/plugins/parsers/"
					+ source.getParser().getName() + ".jar");
			
			downloadManager.setDownloader(downloader.newInstance());
			file = downloadManager.getFileToParseGz(source.getUrl(),
					PROJECT_DIR + source.getDirname());

			Object parserObj = parser.newInstance();
			Method method = parser.getMethod("parse", File.class);
			List<String> outList = (List<String>) method
					.invoke(parserObj, file);

			for (String ip : outList) {
				if (IpValidator.isIpV4(ip)) {
					//System.out.println(ip);
					result.addToIpV4List(new IpV4Address(ip, new Date()));
				} else if (IpValidator.isIpV6(ip)) {
					//System.out.println(ip);
					result.addToIpV6List(new IpV6Address(ip, new Date()));
				} else {
					//System.out.println(ip);
					result.addToNotValidList(new NotValidIp(ip, new Date()));
				}
			}
			result.setSourceId(source.getSourceId());
			System.out.println("Finished Parsing Data");

			// file = downloader.downloadFile(source.getUrl(), PROJECT_DIR
			// + source.getDirname());
			// result = parserMap.get(source).parse(file);
			// result.setSourceId(source.getSourceId());
			// break;

			System.out.println(result.getIpV4List().size());
			System.out.println(result.getIpV6List().size());
			System.out.println(result.getNotValidList().size());

			LOGGER.info("Finish downloading, parsing and updating sources.");
			return result;

		} catch (Exception e) {
			LOGGER.error(e);
			throw new SourceDownloaderServiceException(
					"Data didn't downloaded ", e);
		}
	}

	@Transactional
	@Override
	public List<Source> loadSourceList()
			throws SourceDownloaderServiceException {
		List<Source> sourcesList;
		try {
			sourcesList = sourceDao.findAll();
			sourcesList.remove(sourceDao.findByName(ADMIN_BLACK_LIST));
			sourcesList.remove(sourceDao.findByName(ADMIN_WHITE_LIST));
			return sourcesList;

		} catch (Exception e) {
			LOGGER.error(e);
			throw new SourceDownloaderServiceException(
					"Could not load list of sources", e);
		}
	}

	// @SuppressWarnings("unchecked")
	// @Transactional
	// @Override
	// public Map<Source, Parser> createParserMap(List<Source> sourceList)
	// throws SourceDownloaderServiceException {
	// LOGGER.info("Start creating Map of Sources and Parsers.");
	// Map<Source, Parser> parserMap = new HashMap<Source, Parser>();
	//
	// for (Source source : sourceList) {
	//
	// if (source.getParser() != null) {
	// Class<Parser> parserClass;
	//
	// try {
	// parserClass = (Class<Parser>) Class.forName(source
	// .getParser());
	//
	// } catch (Exception e) {
	// LOGGER.error(e);
	// throw new SourceDownloaderServiceException(
	// "Can't find Class of Parser!", e);
	// }
	//
	// Parser parser = null;
	//
	// try {
	// parser = (Parser) parserClass.newInstance();
	//
	// } catch (Exception e) {
	// LOGGER.error(e);
	// throw new SourceDownloaderServiceException(
	// "class of Parser cannot be instantiated!", e);
	// }
	//
	// parserMap.put(source, parser);
	// }
	// }
	// LOGGER.info("Finish creating Map of Sources and Parsers.");
	// return parserMap;
	// }
	//
	// @Transactional
	// @Override
	// public void updateStatusList() throws SourceDownloaderServiceException {
	// LOGGER.info("Start update WhiteList");
	// try {
	// ipAddressService.updateStatusList(IpAddress.IP_MAP);
	//
	// } catch (Exception e) {
	// LOGGER.error(e);
	// throw new
	// SourceDownloaderServiceException("class of Parser cannot be instantiated!",
	// e);
	// }
	// LOGGER.info("Finish update WhiteList");
	// }

}
