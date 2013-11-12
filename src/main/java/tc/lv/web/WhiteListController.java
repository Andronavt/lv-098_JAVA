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

import tc.lv.exceptions.SourceServiseException;
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
	public @ResponseBody
	String deleteFromWL(@ModelAttribute("address") String ipAddress,
			BindingResult result) throws SourceServiseException {

		try {
			if (IpValidator.isIpV4(ipAddress)) {
				wlService.deleteIpV4(ipAddress);
				return "IpV4: " + ipAddress + " has been successfully deleted.";
			} else if (IpValidator.isIpV6(ipAddress)) {
				wlService.deleteIpV6(ipAddress);
				return "IpV6: " + ipAddress + " has been successfully deleted.";
			} else {
				throw new SourceServiseException("Incorrect IP-address!");
			}
		} catch (Exception e) {
			throw new SourceServiseException("Incorrect IP-address!", e);
		}
	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/addIpToWL", method = RequestMethod.GET)
	public String addToWl() {
		return "addIpToWL";
	}

	// Add IP-address from WhiteList
	// @RequestMapping(value = "/addIpToWL", method = RequestMethod.POST)
	// public @ResponseBody
	// String addToWl(@ModelAttribute("address") String ipAddress,
	// BindingResult result) throws SourceServiseException {
	// try {
	// if (IpValidator.isIpV4(ipAddress)) {
	// wlService.saveIpV4(ipAddress);
	// return "IpV4: " + ipAddress
	// + " has been successfully added to WhiteList.";
	// } else if (IpValidator.isIpV6(ipAddress)) {
	// wlService.saveIpV6(ipAddress);
	// return "IpV6: " + ipAddress
	// + " has been successfully added to WhiteList.";
	// } else {
	// throw new SourceServiseException("Incorrect IP-address!");
	// }
	// } catch (Exception e) {
	// throw new SourceServiseException("Incorrect IP-address!", e);
	// }
	//
	// }

	// Add IP-address from WhiteList
	@RequestMapping(value = "/addIpToWL", method = RequestMethod.POST)
	public String addToWl(@ModelAttribute("address") String ipAddress,
			Map<String, Object> map) {
		try {
			if (IpValidator.isIpV4(ipAddress)) {
				wlService.saveIpV4(ipAddress);
				map.put("addIpV4", ipAddress
						+ " has been successfully added to WhiteList.");
				return "result";
			} else if (IpValidator.isIpV6(ipAddress)) {
				wlService.saveIpV6(ipAddress);
				map.put("addIpV6", ipAddress
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

	// Add IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWl() {
		return "showIpListFromWL";
	}

	// Add IP-address from WhiteList
	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWl(Map<String, Object> map)
			throws SourceServiseException {
		try {
			map.put("ipList", wlService.loadIpV4List());
			return "showIpListFromWL"; // Need create alone jsp-page
		} catch (Exception e) {
			throw new SourceServiseException("Incorrect IP-address!", e);
		}
	}
}