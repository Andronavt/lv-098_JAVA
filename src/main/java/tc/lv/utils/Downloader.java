package tc.lv.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Downloader {

	long timeStamp = new Date().getTime();
	String fileName = Long.toString(timeStamp) + ".txt";

	public Downloader() {

	}

	public String downloadFile(String urlString, String dir) {

		BufferedInputStream inputStream = null;
		GZIPInputStream gInputStream = null;

		FileOutputStream outputFile = null;
		GZIPOutputStream gZipFile = null;
		File file = null;
		if (urlString.contains(".gz")) {
			try {

				file = new File(dir + fileName);
				System.out.println(file.toString());

				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());

				gInputStream = new GZIPInputStream(inputStream);

				gZipFile = new GZIPOutputStream(new FileOutputStream(file));

				byte data[] = new byte[1024];
				int count;

				while ((count = gInputStream.read(data, 0, 1024)) != -1) {
					System.out.println(data.toString());
					gZipFile.write(data, 0, count);
				}

			} catch (IOException e) {

			} finally {
				if (gInputStream != null) {
					try {
						gInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (gZipFile != null) {
					try {
						gZipFile.flush();
						gZipFile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			unZip(file);
		} else {
			try {
				inputStream = new BufferedInputStream(
						new URL(urlString).openStream());
				outputFile = new FileOutputStream(dir + fileName);

				byte data[] = new byte[1024];
				int count;

				while ((count = inputStream.read(data, 0, 1024)) != -1) {
					// System.out.println(data.toString());
					outputFile.write(data, 0, count);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (outputFile != null) {
					try {
						outputFile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return dir + fileName;
	}

	public void unZip(File file) {

		FileInputStream fileInput = null;
		GZIPInputStream gzInput = null;
		FileOutputStream fileOutput = null;

		try {
			String outputFileName = file.getAbsolutePath();

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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gzInput != null) {
				try {
					gzInput.close();
				} catch (IOException e) {
					System.err.println("gzINputt failed");
					e.printStackTrace();
				}
			}
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (IOException e) {
					System.err.println("fileOutput failed");
					e.printStackTrace();
				}
			}
		}
	}
}
