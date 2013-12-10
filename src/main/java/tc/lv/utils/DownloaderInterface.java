package tc.lv.utils;

import java.io.File;

public interface DownloaderInterface {

	public File downloadFile(String urlString, String dir) throws Exception;
	public File extract(File file) throws Exception;

}
