package tc.lv.service;

import java.util.List;

import tc.lv.utils.ParserResult;

public interface ParserResultService {

    public void saveAllSources(List<ParserResult> resultList);

    public void save(ParserResult result);
}
