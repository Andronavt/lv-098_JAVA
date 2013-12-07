package tc.lv.utils;

import java.io.File;

import tc.lv.exceptions.DownloadException;

public interface Parser {

    public ParserResults parse(File file) throws DownloadException;
}
