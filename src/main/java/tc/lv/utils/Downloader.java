package tc.lv.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;

public abstract class Downloader implements DownloaderInterface {

	private static long timeStamp = new Date().getTime();
	private static String fileName = Long.toString(timeStamp);

	public Downloader() {
	}

	public File downloadFile(String urlString, String dir) throws Exception {

		BufferedInputStream inputStream = null;

		FileOutputStream outputFile = null;

		File file = null;

		try {

			file = new File(dir + fileName+urlString.substring(urlString.lastIndexOf("."), urlString.length()));
			inputStream = new BufferedInputStream(
					new URL(urlString).openStream());
			outputFile = new FileOutputStream(file);

			byte data[] = new byte[1024];
			int count;
			while ((count = inputStream.read(data, 0, 1024)) != -1) {
				outputFile.write(data, 0, count);
			}
		} catch (Exception e) {
			throw new Exception(
					"no legal protocol could be found in a specification string or the string could not be parsed",
					e);
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					throw new Exception("Can't close inputStream!", e);
				}
			}

			if (outputFile != null) {
				try {
					outputFile.close();
				} catch (Exception e) {
					throw new Exception("Can't close outputFile!", e);
				}
			}
		}

		return file;
	}

	public abstract File extract(File file) throws Exception;
}
