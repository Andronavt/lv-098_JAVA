package tc.lv.dao;

import tc.lv.utils.ParserResults;

public interface DownloaderDao {

    void save(ParserResults parser);

    void updateWhiteList();

}
