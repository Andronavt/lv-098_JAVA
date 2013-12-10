package tc.lv.utils;

import java.io.File;

import tc.lv.exceptions.DownloadException;

public class DownloadManager {

	public DownloaderInterface downloader;

	public DownloadManager() {

	}

	public void setDownloader(DownloaderInterface downloader) {
		this.downloader = downloader;
	}

	public File getFileToParseTxt(String urlString, String dir)
			throws DownloadException {
		try {
			return downloader.downloadFile(urlString, dir);
		} catch (Exception e) {
			throw new DownloadException("Could not download file", e);
		}
	}
	public File getFileToParseGz(String urlString, String dir)
			throws DownloadException {
		File downloadFile = null;
		try {
			downloadFile = downloader.downloadFile(urlString, dir);
			System.out.println("dOWNLoaDsfafas"+downloadFile.getName());
			if (downloadFile.getName().contains(".txt")) {
				return downloadFile;
			}
			return downloader.extract(downloadFile);
		} catch (Exception e) {
			throw new DownloadException("Could not Extraxt file", e);
		}

	}
}
