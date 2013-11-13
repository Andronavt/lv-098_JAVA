package tc.lv.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Logger;

import tc.lv.exceptions.DownloadException;

public class Downloader {

	long timeStamp = new Date().getTime();
	String fileName = Long.toString(timeStamp);
	private static final Logger loggerErr = Logger.getLogger("errorLog");
	private static final Logger loggerInfo = Logger.getLogger("infoLog");

	public Downloader() {

	}

	public File downloadFile(String urlString, String dir)
			throws DownloadException {
		loggerInfo.info("START DOWNLOADING");
		BufferedInputStream inputStream = null;
		GZIPInputStream gInputStream = null;

		FileOutputStream outputFile = null;
		GZIPOutputStream gZipFile = null;
		File file = null;
		File fileOut = null;

		if (urlString.contains(".gz")) {
			try {
				file = new File(dir + fileName + ".gz");
				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());
				gInputStream = new GZIPInputStream(inputStream);
				gZipFile = new GZIPOutputStream(new FileOutputStream(file));

				byte data[] = new byte[1024];
				int count;

				while ((count = gInputStream.read(data, 0, 1024)) != -1) {
					gZipFile.write(data, 0, count);
				}
			} catch (Exception e) {
				loggerErr.error(e);
				throw new DownloadException(
						"no legal protocol could be found in a specification string or the string could not be parsed",
						e);
			} finally {
				if (gInputStream != null) {
					try {
						gInputStream.close();
					} catch (Exception e) {
						loggerErr.error(e);
						throw new DownloadException(
								"Can't close gInputStream!", e);
					}
				}
				if (gZipFile != null) {
					try {
						gZipFile.flush();
						gZipFile.close();
					} catch (Exception e) {
						loggerErr.error(e);
						throw new DownloadException("Can't close gZipFile!", e);
					}
				}
			}
			System.out.println("UNZIPPING");

			fileOut = unZip(file);
			System.out.println("DOWNLOADING AND UNZIPPING COMPLETED");
			return fileOut;

		} else {
			try {
				file = new File(dir + fileName + ".txt");
				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());
				outputFile = new FileOutputStream(file);

				byte data[] = new byte[1024];
				int count;

				while ((count = inputStream.read(data, 0, 1024)) != -1) {
					outputFile.write(data, 0, count);
				}
				fileOut = file;
			} catch (Exception e) {
				loggerErr.error(e);
				throw new DownloadException(
						"no legal protocol could be found in a specification string or the string could not be parsed",
						e);
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (Exception e) {
						loggerErr.error(e);
						throw new DownloadException("Can't close inputStream!",
								e);
					}
				}
				if (outputFile != null) {
					try {
						outputFile.close();
					} catch (Exception e) {
						loggerErr.error(e);
						throw new DownloadException("Can't close outputFile!",
								e);
					}
				}
			}
		}
		loggerInfo.info("FINISH DOWNLOADING");
		return fileOut;
	}

	public File unZip(File file) throws DownloadException {

		FileInputStream fileInput = null;
		GZIPInputStream gzInput = null;
		FileOutputStream fileOutput = null;

		try {
			File outputFileName = new File(file.getAbsolutePath() + ".txt");
			fileInput = new FileInputStream(file);
			gzInput = new GZIPInputStream(fileInput);

			fileOutput = new FileOutputStream(outputFileName);

			byte[] buffer = new byte[1024];
			int count;

			while ((count = gzInput.read(buffer, 0, 1024)) != -1) {
				fileOutput.write(buffer, 0, count);
			}
			return outputFileName;

		} catch (Exception e) {
			loggerErr.error(e);
			throw new DownloadException("Can't find file for unzip!", e);
		} finally {
			if (gzInput != null) {
				try {
					gzInput.close();
				} catch (Exception e) {
					loggerErr.error(e);
					throw new DownloadException("Can't close gzInput!", e);
				}
			}
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (Exception e) {
					loggerErr.error(e);
					throw new DownloadException("Can't close fileOutput!", e);
				}
			}
		}
	}
}
