package tc.lv.service;

import java.util.List;

import tc.lv.domain.Source;
import tc.lv.exceptions.SourceServiseException;

public interface SourceService {

    public boolean addNewFeed(String parser, String sourceName, String url, String listType, Double rank)
            throws SourceServiseException;

    public boolean deleteFeedByName(String sourceName) throws SourceServiseException;

    public List<Source> getListOfSourcess() throws SourceServiseException;

}
