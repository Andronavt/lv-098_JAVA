package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.service.WhiteListService;

@Controller
public class WhiteListController {
	@Autowired
	private WhiteListService wlService;

	@RequestMapping(value = "/deleteIpFromWL", method = RequestMethod.GET)
	public String deleteFromWL() {
		return "deleteIpFromWL";
	}

	@RequestMapping(value = "/deleteIpFromWL", method = RequestMethod.POST)
	public @ResponseBody
	String deleteFromWL(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			if (ipAddress.contains(".")) {
				wlService.deleteIpV4(ipAddress);
				return "IpV4: " + ipAddress + " has been successfully deleted.";
			} else if (ipAddress.contains(":")) {
				wlService.deleteIpV6(ipAddress);
				return "IpV6: " + ipAddress + " has been successfully deleted.";
			} else {
				String response = "Some problems occurred with deleting IpAddress "
						+ ipAddress + " !!!";
				return response;
			}
		} catch (RuntimeException e) {
			return "Where was error with deleting " + ipAddress + "!!!\n"
					+ e.toString();
		}
	}

	@RequestMapping(value = "/addIpToWL", method = RequestMethod.GET)
	public String addToWl() {
		return "addIpToWL";
	}

	@RequestMapping(value = "/addIpToWL", method = RequestMethod.POST)
	public @ResponseBody
	String addToWl(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			// TODO: Add here validation
			if (ipAddress.contains(".")) {
				wlService.saveIpV4(ipAddress);
				return "IpV4: " + ipAddress
						+ " has been successfully added to WhiteList.";
			} else if (ipAddress.contains(":")) {
				wlService.saveIpV6(ipAddress);
				return "IpV6: " + ipAddress
						+ " has been successfully added to WhiteList.";
			} else {
				String response = "Some problems occurred adding IpAddress "
						+ ipAddress + " !!!";
				return response;
			}
		} catch (RuntimeException e) {
			// TODO: handle exception
			return "Where was error with adding " + ipAddress + "!!!\n"
					+ e.toString();
		}
	}

	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWl() {
		return "showIpListFromWL";
	}

	@RequestMapping(value = "/showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWl(Map<String, Object> map) {
		map.put("ipList", wlService.loadIpV4List());
		return "listIpv4";
	}
}
