package tc.lv.service;

import java.util.List;

import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.utils.ParserResults;

public interface ParserResultService {

	public void saveAllSources(List<ParserResults> resultList)
			throws ParserResultServiceException;

	public void save(ParserResults result) throws ParserResultServiceException;
}
