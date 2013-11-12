package tc.lv.utils;

import java.io.File;

import tc.lv.exceptions.DownloadException;

public interface ParserInterface {
	public ParserResults parse(File f) throws DownloadException;
}
