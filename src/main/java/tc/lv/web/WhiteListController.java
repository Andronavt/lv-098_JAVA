package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
				wlService.deleteIpV4(ipAddress);
				map.put("successMsg", "IpV4: " + ipAddress
						+ " has been successfully deleted.");
				return "result";
			} else if (IpValidator.isIpV6(ipAddress)) {
				wlService.deleteIpV6(ipAddress);
				map.put("successMsg", "IpV6: " + ipAddress
						+ " has been successfully deleted.");
				return "result";
			} else {
				throw new WhiteListServiceException("Incorrect IP-address!");
			}
		} catch (WhiteListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
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
				wlService.saveIpV4(ipAddress);
				map.put("successMsg", ipAddress
						+ " has been successfully added to WhiteList.");
				return "result";
			} else if (IpValidator.isIpV6(ipAddress)) {
				wlService.saveIpV6(ipAddress);
				map.put("successMsg", ipAddress
						+ " has been successfully added to WhiteList.");
				return "result";
			} else {
				throw new WhiteListServiceException("Incorrect IP-address!");
			}
		} catch (WhiteListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

	// Show IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWl() {
		return "showIpListFromWL";
	}

	// Show IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWl(Map<String, Object> map) {
		try {
			map.put("ipList", wlService.loadIpV4List());
			return "showIpListFromWL"; // Need create alone jsp-page
		} catch (WhiteListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}
}