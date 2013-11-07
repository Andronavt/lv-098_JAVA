package tc.lv.service;

import java.util.List;


import tc.lv.utils.ParserResults;

public interface ParserResultService {

    public void saveAllSources(List<ParserResults> resultList);

    public void save(ParserResults result);
}
