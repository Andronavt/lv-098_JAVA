package tc.lv.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;
import tc.lv.utils.ExceptionUtil;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    // showStatusListByCity
    @RequestMapping(value = "secure_showListByCity", method = RequestMethod.GET)
    public String showStatusListByCity() {
        return "secure_showListByCity";
    }

    // showStatusListByCity
    @RequestMapping(value = "secure_showListByCity", method = RequestMethod.POST)
    public String showStatusListByCity(@ModelAttribute("pageNumber") int pageNumber,
            @ModelAttribute("countIpPerPage") int countIpPerPage, @ModelAttribute("location") String cityName,
            @ModelAttribute("ipType") int ipTypeUI, @ModelAttribute("status") int statusUI, Map<String, Object> map) {
        int from;
        int ipCount;
        int pageCount;
        List<IpAddress> ipList;
        List<Integer> pageList;
        List<String> locationList;
        try {

            ipCount = locationService
                    .countStatusIpByCityName(cityName, makeIpType(ipTypeUI), makeStatus(statusUI)).intValue();
            pageCount = ipCount / countIpPerPage + 1;

            from = (pageNumber - 1) * countIpPerPage;
            ipList = locationService.findStatusListByCity(from, countIpPerPage, cityName, makeIpType(ipTypeUI),
                    makeStatus(statusUI));

            locationList = locationService.findCityListByStatus(makeIpType(ipTypeUI), makeStatus(statusUI));

           // map.put("pageList", pageList); //
            map.put("pageCount", pageCount); // Count of pages
            map.put("ipList", ipList); // List of IP-addresses
            map.put("locationList", locationList); // List of cities

        } catch (LocationServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "secure_table";
    }

    // showStatusListByCountry
    @RequestMapping(value = "secure_showListByCountry", method = RequestMethod.GET)
    public String showStatusListByCountry() {
        return "secure_showListByCountry";
    }

    // showStatusListByCountry
    @RequestMapping(value = "secure_showListByCountry", method = RequestMethod.POST)
    public String showStatusListByCountry(@ModelAttribute("pageNumber") int pageNumber,
            @ModelAttribute("countIpPerPage") int countIpPerPage, @ModelAttribute("location") String countryName,
            @ModelAttribute("ipType") int ipTypeUI, @ModelAttribute("status") int statusUI, Map<String, Object> map) {
        int from;
        int ipCount;
        int pageCount;
        List<IpAddress> ipList;
        List<Integer> pageList;
        List<String> locationList;
        try {

            ipCount = locationService.countStatusIpByCountryName(countryName, makeIpType(ipTypeUI),
                    makeStatus(statusUI)).intValue();
            pageCount = ipCount / countIpPerPage + 1;

            from = (pageNumber - 1) * countIpPerPage;
            ipList = locationService.findStatusListByCountry(from, countIpPerPage, countryName,
                    makeIpType(ipTypeUI), makeStatus(statusUI));

            locationList = locationService.findCountryListByStatus(makeIpType(ipTypeUI), makeStatus(statusUI));

          //  map.put("pageList", pageList); //
            map.put("pageCount", pageCount); // Count of pages
            map.put("ipList", ipList); // List of IP-addresses
            map.put("locationList", locationList); // List of cities

        } catch (LocationServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "secure_table";
    }

    private Class<? extends IpAddress> makeIpType(int ipType) {
        if (ipType == 0)
            return IpV4Address.class;
        if (ipType == 1)
            return IpV6Address.class;
        return IpAddress.class;
    }

    private boolean makeStatus(int status) {
        return (status == 1 ? true : false);
    }

}
