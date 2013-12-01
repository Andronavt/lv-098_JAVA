package tc.lv.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpAddress;
import tc.lv.domain.PaginationSettings;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;
import tc.lv.service.PaginationService;
import tc.lv.utils.ExceptionUtil;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    PaginationService paginationService;

    // showStatusListByCity
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_showIpListByCity", method = RequestMethod.GET)
    public String showStatusListByCity(Map<String, Object> map) {

	map.put("pageList", paginationService.loadPages());
	try {
	    map.put("locationList",
		    locationService.findCityListByStatus("allIp", "blackList"));
	} catch (LocationServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
	return "secure_showIpListByCity";
    }

    // showStatusListByCity
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_showIpListByCity", method = RequestMethod.POST)
    public String showStatusListByCity(
	    @ModelAttribute("pageNumber") int pageNumber,
	    @ModelAttribute("countIpPerPage") int countIpPerPage,
	    @ModelAttribute("location") String cityName,
	    @ModelAttribute("ipType") String ipTypeUI,
	    @ModelAttribute("status") String statusUI, Map<String, Object> map) {
	int ipCount;
	int pageCount;
	List<IpAddress> ipList;
	List<PaginationSettings> pageList;
	List<String> locationList;
	try {
	    ipCount = locationService.countStatusIpByCityName(cityName,
		    ipTypeUI, statusUI).intValue();
	    pageCount = ipCount / countIpPerPage + 1;
	    ipList = locationService.findStatusListByCity((pageNumber - 1)
		    * countIpPerPage, countIpPerPage, cityName, ipTypeUI,
		    statusUI);

	    locationList = locationService.findCityListByStatus(ipTypeUI,
		    statusUI);

	    pageList = paginationService.loadPages();

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
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_showIpListByCountry", method = RequestMethod.GET)
    public String showStatusListByCountry(Map<String, Object> map) {
	map.put("pageList", paginationService.loadPages());
	try {
	    map.put("locationList", locationService.findCountryListByStatus(
		    "allIp", "blackList"));

	} catch (LocationServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
	return "secure_showIpListByCountry";
    }

    // showStatusListByCountry
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_showIpListByCountry", method = RequestMethod.POST)
    public String showStatusListByCountry(
	    @ModelAttribute("pageNumber") int pageNumber,
	    @ModelAttribute("countIpPerPage") int countIpPerPage,
	    @ModelAttribute("location") String countryName,
	    @ModelAttribute("ipType") String ipTypeUI,
	    @ModelAttribute("status") String statusUI, Map<String, Object> map) {
	int ipCount;
	int pageCount;
	List<IpAddress> ipList;
	List<PaginationSettings> pageList;
	List<String> locationList;
	try {
	    ipCount = locationService.countStatusIpByCountryName(countryName,
		    ipTypeUI, statusUI).intValue();
	    pageCount = ipCount / countIpPerPage + 1;
	    ipList = locationService.findStatusListByCountry((pageNumber - 1)
		    * countIpPerPage, countIpPerPage, countryName, ipTypeUI,
		    statusUI);
	    locationList = locationService.findCountryListByStatus(ipTypeUI,
		    statusUI);
	    pageList = paginationService.loadPages();

	    map.put("pageList", pageList);
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
