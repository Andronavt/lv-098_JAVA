package tc.lv.utils.mytest;

import java.io.File;

import tc.lv.exceptions.DownloadException;
import tc.lv.utils.ParserResults;

public interface MyParserInterface {

	public ParserResults parse(File file) throws DownloadException;

}
