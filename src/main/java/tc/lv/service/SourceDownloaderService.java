package tc.lv.service;

import tc.lv.domain.Source;
import tc.lv.utils.Parser;

public interface SourceDownloaderService {
	public Source loadSourceByName(String sourceName);
	public void updateSource(Parser parser);
}
