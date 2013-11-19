package tc.lv.service;

import tc.lv.exceptions.JsonServiceException;

public interface JsonService {

    public void createJsonCountryWhiteList(String path) throws JsonServiceException;
    
    public void createJsonCountryBlackList(String path) throws JsonServiceException;

}
