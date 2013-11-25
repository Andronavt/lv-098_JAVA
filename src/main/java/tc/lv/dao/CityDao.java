package tc.lv.dao;

import java.util.List;

import tc.lv.domain.City;
import tc.lv.exceptions.DBException;

public interface CityDao {

    List<String> findCityNameListByStatus(boolean status) throws DBException;

}
