package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;
import tc.lv.exceptions.IpValidationException;
import tc.lv.service.WhiteListService;
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
	public @ResponseBody
	String deleteFromWL(@ModelAttribute("address") String ipAddress,
			BindingResult result) throws DBPersistanceException,
			DBIllegalArgumentException, DBIllegalStateException, DBException,
			IpValidationException {

		if (IpValidator.isIpV4(ipAddress)) {
			wlService.deleteIpV4(ipAddress);
			return "IpV4: " + ipAddress + " has been successfully deleted.";
		} else if (IpValidator.isIpV6(ipAddress)) {
			wlService.deleteIpV6(ipAddress);
			return "IpV6: " + ipAddress + " has been successfully deleted.";
		} else {
			throw new IpValidationException("Incorrect IP-address!");
		}
	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/addIpToWL", method = RequestMethod.GET)
	public String addToWl() {
		return "addIpToWL";
	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/addIpToWL", method = RequestMethod.POST)
	@ExceptionHandler((DBException.class))
	public @ResponseBody
	String addToWl(@ModelAttribute("address") String ipAddress,
			BindingResult result) throws IpValidationException,
			DBPersistanceException, DBIllegalArgumentException,
			DBIllegalStateException, DBException {		
		if (IpValidator.isIpV4(ipAddress)) {
			wlService.saveIpV4(ipAddress);
			return "IpV4: " + ipAddress
					+ " has been successfully added to WhiteList.";
		} else if (IpValidator.isIpV6(ipAddress)) {
			wlService.saveIpV6(ipAddress);
			return "IpV6: " + ipAddress
					+ " has been successfully added to WhiteList.";
		} else {
			throw new IpValidationException("Incorrect IP-address!");
		}

	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWl() {
		return "showIpListFromWL";
	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWl(Map<String, Object> map)
			throws DBPersistanceException, DBIllegalArgumentException,
			DBIllegalStateException, DBException {
		map.put("ipList", wlService.loadIpV4List());
		return "showIpListFromWL"; // Need create alone jsp-page
	}
}
