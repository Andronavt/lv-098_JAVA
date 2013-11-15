package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpV4Address;
import tc.lv.exceptions.WhiteListServiceException;
import tc.lv.service.WhiteListService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

@Controller
public class WhiteListController {

    @Autowired
    private WhiteListService wlService;

    // Delete IP-address from WhiteList
    @RequestMapping(value = "/deleteIpFromWL", method = RequestMethod.GET)
    public String deleteFromWL() {
	return "deleteIpFromWL";
    }

    // Delete IP-address from WhiteList
    @RequestMapping(value = "/deleteIpFromWL", method = RequestMethod.POST)
    public String deleteFromWL(@ModelAttribute("address") String ipAddress,
	    Map<String, Object> map) {

	try {
	    if (IpValidator.isIpV4(ipAddress)) {
		return deleteIpFromDB(wlService.deleteIpV4(ipAddress),
			ipAddress, map);

	    } else if (IpValidator.isIpV6(ipAddress)) {
		return deleteIpFromDB(wlService.deleteIpV6(ipAddress),
			ipAddress, map);

	    } else {
		map.put("incorrectMsg", "Incorrect IP-address!");
		return "result";
	    }

	} catch (WhiteListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
    }

    // delete IP from DB
    private String deleteIpFromDB(boolean flag, String ipAddress,
	    Map<String, Object> map) throws WhiteListServiceException {

	if (flag) {
	    map.put("successMsg", "IP-address: " + ipAddress
		    + " has been successfully deleted.");
	    return "result";

	}
	map.put("incorrectMsg", "Current IP-address don't exist");
	return "result";
    }

    // Add IP-address to WhiteList
    @RequestMapping(value = "/addIpToWL", method = RequestMethod.GET)
    public String addToWl() {
	return "addIpToWL";
    }

    // Add IP-address to WhiteList
    @RequestMapping(value = "/addIpToWL", method = RequestMethod.POST)
    public String addToWl(@ModelAttribute("address") String ipAddress,
	    Map<String, Object> map) {

	try {
	    if (IpValidator.isIpV4(ipAddress)) {
		return addIpFromDB(wlService.saveIpV4(ipAddress), ipAddress,
			map);

	    } else if (IpValidator.isIpV6(ipAddress)) {
		return addIpFromDB(wlService.saveIpV6(ipAddress), ipAddress,
			map);

	    } else {
		map.put("incorrectMsg", "Incorrect IP-address!");
		return "result";
	    }

	} catch (WhiteListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
    }

    // add IP to DB
    private String addIpFromDB(boolean flag, String ipAddress,
	    Map<String, Object> map) throws WhiteListServiceException {

	if (flag) {
	    map.put("successMsg", "IP-address: " + ipAddress
		    + " has been successfully added to WhiteList.");
	    return "result";
	}
	map.put("incorrectMsg", "Current IP-address exist");
	return "result";
    }

    // Show IP-address from WhiteList
    @RequestMapping(value = "/showIpListFromWL", method = RequestMethod.GET)
    public String showIpListFromWl() {
	return "showIpListFromWL";
    }

    // Show IP-address from WhiteList
    // @RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
    // public String showIpListFromWl(Map<String, Object> map) {
    //
    // try {
    // map.put("ipList", wlService.loadIpV4List());
    // return "showIpListFromWL";
    //
    // } catch (WhiteListServiceException e) {
    // map.put("errorList", ExceptionUtil.createErrorList(e));
    // map.put("errorMsg", e.getMessage());
    // return "result";
    // }
    // }

    @RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
    public String showIpListFromWl(@ModelAttribute("page") String page,
	    @ModelAttribute("value") String value, Map<String, Object> map) {

	try {
	    List<IpV4Address> list = new ArrayList<>();
	    list.addAll(wlService.loadIpV4ListByRange(Integer.parseInt(page)
		    * Integer.parseInt(value), Integer.parseInt(value)));
	    map.put("ipList", list);

	} catch (WhiteListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
	return "showIpListFromWL";
    }
}