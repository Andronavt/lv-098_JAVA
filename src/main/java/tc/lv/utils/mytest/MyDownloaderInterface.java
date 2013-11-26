package tc.lv.utils.mytest;

import java.io.File;

import tc.lv.exceptions.DownloadException;

public interface MyDownloaderInterface {

	public File downloadFile(String urlString, String dir)
			throws DownloadException;

	public File unZip(File file) throws DownloadException;

}
