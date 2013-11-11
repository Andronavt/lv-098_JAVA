package tc.lv.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Logger;

import tc.lv.exceptions.DownloadFileNotFoundException;
import tc.lv.exceptions.DownloadIOException;
import tc.lv.exceptions.DownloadMalformedURLException;

public class Downloader {

	long timeStamp = new Date().getTime();
	String fileName = Long.toString(timeStamp);
	private static final Logger loggerErr = Logger.getLogger("errorLog");

	public Downloader() {

	}

	public File downloadFile(String urlString, String dir)
			throws DownloadFileNotFoundException, DownloadIOException,
			DownloadMalformedURLException {

		BufferedInputStream inputStream = null;
		GZIPInputStream gInputStream = null;

		FileOutputStream outputFile = null;
		GZIPOutputStream gZipFile = null;
		File file = null;
		File fileOut = null;
		
		if (urlString.contains(".gz")) {
			try {
			    	System.err.println("START DOWNLOADING");
				file = new File(dir + fileName + ".gz");
				System.out.println(dir + fileName);

				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());

				gInputStream = new GZIPInputStream(inputStream);

				gZipFile = new GZIPOutputStream(new FileOutputStream(file));

				byte data[] = new byte[1024];
				int count;

				while ((count = gInputStream.read(data, 0, 1024)) != -1) {
					gZipFile.write(data, 0, count);
				}
			} catch (MalformedURLException e) {
				loggerErr.error(e);
				throw new DownloadMalformedURLException(
						"no legal protocol could be found in a specification string or the string could not be parsed");
			} catch (FileNotFoundException e) {
				loggerErr.error(e);
				throw new DownloadFileNotFoundException(
						"Can't find file for unzip!");
			} catch (IOException e) {
				loggerErr.error(e);
				throw new DownloadIOException(
						"Can't download file from source!");
			} finally {
				if (gInputStream != null) {
					try {
						gInputStream.close();
					} catch (IOException e) {
						loggerErr.error(e);
						throw new DownloadIOException(
								"Can't close gInputStream!");
					}
				}
				if (gZipFile != null) {
					try {
						gZipFile.flush();
						gZipFile.close();
					} catch (IOException e) {
						loggerErr.error(e);
						throw new DownloadIOException("Can't close gZipFile!");
					}
				}
			}
			System.out.println("UNZIPPING");
			unZip(file);
			fileOut = file;
			System.out.println("DOWNLOADING AND UNZIPPING COMPLETED");
		} else {
			try {
			    	System.err.println("START DOWNLOADING");
				file = new File(dir + fileName + ".txt");
				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());
				outputFile = new FileOutputStream(file);
				System.out.println("OUR FILE IS: " + dir + fileName);

				byte data[] = new byte[1024];
				int count;

				while ((count = inputStream.read(data, 0, 1024)) != -1) {
					outputFile.write(data, 0, count);
				}
				fileOut = file;
			} catch (MalformedURLException e) {
				loggerErr.error(e);
				throw new DownloadMalformedURLException(
						"no legal protocol could be found in a specification string or the string could not be parsed");
			} catch (IOException e) {
				loggerErr.error(e);
				throw new DownloadIOException(
						"Can't download file from source!");
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						loggerErr.error(e);
						throw new DownloadIOException(
								"Can't close inputStream!");
					}
				}
				if (outputFile != null) {
					try {
						outputFile.close();
					} catch (IOException e) {
						loggerErr.error(e);
						throw new DownloadIOException("Can't close outputFile!");
					}
				}
			}
		}
		System.out.println("DOWNLOADING COMPLETED");
		return fileOut;
	}

	public void unZip(File file) throws DownloadFileNotFoundException,
			DownloadIOException {

		FileInputStream fileInput = null;
		GZIPInputStream gzInput = null;
		FileOutputStream fileOutput = null;

		try {
			String outputFileName = file.getAbsolutePath() + ".txt";
			// String outputFileName = "D:\\textfiles\\";

			System.err.println("File for extracting " + outputFileName);

			fileInput = new FileInputStream(file);
			gzInput = new GZIPInputStream(fileInput);

			fileOutput = new FileOutputStream(outputFileName);

			byte[] buffer = new byte[1024];
			int count;

			while ((count = gzInput.read(buffer, 0, 1024)) != -1) {
				fileOutput.write(buffer, 0, count);
			}
			System.err.println("File successful extract");
		} catch (FileNotFoundException e) {
			loggerErr.error(e);
			throw new DownloadFileNotFoundException(
					"Can't find file for unzip!");
		} catch (IOException e) {
			loggerErr.error(e);
			throw new DownloadIOException("Can't download file from source!");
		} finally {
			if (gzInput != null) {
				try {
					gzInput.close();
				} catch (IOException e) {
					loggerErr.error(e);
					throw new DownloadIOException("Can't close gzInput!");
				}
			}
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (IOException e) {
					loggerErr.error(e);
					throw new DownloadIOException("Can't close fileOutput!");
				}
			}
		}
	}
}
