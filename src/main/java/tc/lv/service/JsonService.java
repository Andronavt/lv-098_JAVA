package tc.lv.service;

import tc.lv.exceptions.JsonException;

public interface JsonService {

    public void createJsonCountryWhiteList(String path) throws JsonException;

    public void createJsonCountryBlackList(String path) throws JsonException;
}
