package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.DBException;

public interface CountryDao {

    List<String> findCountryCodeListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException;

    String findCountryCodeByCountryName(String country, Class<? extends IpAddress> ipType) throws DBException;

    List<String> findCountryNameListByStatus(boolean status, Class<? extends IpAddress> ipType) throws DBException;

}
