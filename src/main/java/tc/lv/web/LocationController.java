package tc.lv.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
import tc.lv.domain.PaginationSettings;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;
import tc.lv.service.implementation.PaginationServiceImpl;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpVersionUtil;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    PaginationServiceImpl paginationServiceImpl;

    // showStatusListByCity
    @RequestMapping(value = "secure_showListByCity", method = RequestMethod.GET)
    public String showStatusListByCity() {
        return "secure_showListByCity";
    }

    // showStatusListByCity
    @RequestMapping(value = "secure_showListByCity", method = RequestMethod.POST)
    public String showStatusListByCity(@ModelAttribute("pageNumber") int pageNumber,
            @ModelAttribute("countIpPerPage") int countIpPerPage, @ModelAttribute("location") String cityName,
            @ModelAttribute("ipType") String ipTypeUI, @ModelAttribute("status") String statusUI,
            Map<String, Object> map) {
        int from;
        int ipCount;
        int pageCount;
        List<IpAddress> ipList;
        List<PaginationSettings> pageList;
        List<City> locationList;
        try {

            ipCount = locationService.countStatusIpByCityName(cityName, IpVersionUtil.ipVersion(ipTypeUI),
                    IpVersionUtil.isWhiteIpAddress(statusUI)).intValue();
            pageCount = ipCount / countIpPerPage + 1;

            from = (pageNumber - 1) * countIpPerPage;
            ipList = locationService.findStatusListByCity(from, countIpPerPage, cityName,
                    IpVersionUtil.ipVersion(ipTypeUI), IpVersionUtil.isWhiteIpAddress(statusUI));

            locationList = locationService.findCityListByStatus(IpVersionUtil.ipVersion(ipTypeUI),
                    IpVersionUtil.isWhiteIpAddress(statusUI));

            pageList = paginationServiceImpl.loadPages();

            map.put("pageList", pageList); //
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
            @ModelAttribute("ipType") String ipTypeUI, @ModelAttribute("status") String statusUI,
            Map<String, Object> map) {
        int from;
        int ipCount;
        int pageCount;
        List<IpAddress> ipList;
        List<PaginationSettings> pageList;
        List<Country> locationList;
        try {

            ipCount = locationService.countStatusIpByCountryName(countryName, IpVersionUtil.ipVersion(ipTypeUI),
                    IpVersionUtil.isWhiteIpAddress(statusUI)).intValue();
            pageCount = ipCount / countIpPerPage + 1;

            from = (pageNumber - 1) * countIpPerPage;
            ipList = locationService.findStatusListByCountry(from, countIpPerPage, countryName,
                    IpVersionUtil.ipVersion(ipTypeUI), IpVersionUtil.isWhiteIpAddress(statusUI));

            locationList = locationService.findCountryListByStatus(IpVersionUtil.ipVersion(ipTypeUI),
                    IpVersionUtil.isWhiteIpAddress(statusUI));
            pageList = paginationServiceImpl.loadPages();

            map.put("pageList", pageList); //
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

}
