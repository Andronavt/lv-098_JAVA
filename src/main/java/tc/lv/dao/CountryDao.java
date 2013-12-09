package tc.lv.dao;

import java.util.List;

import tc.lv.domain.Country;
import tc.lv.exceptions.DBException;

public interface CountryDao {

    List<String> findCountryCodeListByStatus(boolean status) throws DBException;

    String findCountryCodeByCountryName(String country) throws DBException;

    List<String> findCountryNameListByStatus(boolean status) throws DBException;

    void creatCountryMap();

    void save(Country country);

    Country update(Country country);

    boolean isCountryExists(Country country);

}
