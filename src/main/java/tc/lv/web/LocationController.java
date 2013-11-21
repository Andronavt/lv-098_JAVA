package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;
import tc.lv.utils.ExceptionUtil;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    // showBlackListByCountry
    @RequestMapping(value = "secure_showBlackListByCountry", method = RequestMethod.GET)
    public String showBlackListByCountry(Map<String, Object> map) {
        try {
            map.put("BlackListByCountry", locationService.findCountriesBlackList());

        } catch (LocationServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "secure_showBlackListByCountry";
    }

    @RequestMapping(value = "secure_showBlackListByCountry", method = RequestMethod.POST)
    public String showBlackListByCountry(@ModelAttribute("country") String countryName,
            @ModelAttribute("from") String from, @ModelAttribute("count") String count, Map<String, Object> map) {
        try {
            map.put("BlackListOfCountryByRange", locationService.loadBlackListOfCountryByRange(
                    Integer.parseInt(from), Integer.parseInt(count), countryName));
            map.put("PageCount", locationService.countBlackListByCountyName(countryName));
            return "result";

        } catch (LocationServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

    // showWhiteListByCountry
    @RequestMapping(value = "secure_showWhiteListByCountry", method = RequestMethod.GET)
    public String showWhiteListByCountry(Map<String, Object> map) {
        try {
            map.put("BlackListByCountry", locationService.findCountriesWhiteList());

        } catch (LocationServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "secure_showWhiteListByCountry";
    }

    // showBlackListByCity
    @RequestMapping(value = "secure_showBlackListByCity", method = RequestMethod.GET)
    public String showBlackListByCity(Map<String, Object> map) {
        return "secure_showBlackListByCity";
    }

    // showWhiteListByCity
    @RequestMapping(value = "secure_showWhiteListByCity", method = RequestMethod.GET)
    public String showWhiteListByCity(Map<String, Object> map) {
        return "secure_showWhiteListByCountry";
    }

}
