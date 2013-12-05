package tc.lv.service;

import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.utils.ParserResults;

public interface ParserResultService {

    public void save(ParserResults result) throws ParserResultServiceException;

}
