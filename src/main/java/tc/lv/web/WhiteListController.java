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

	@RequestMapping(value = "/admin/WL", method = RequestMethod.GET)
	public String deleteFromWL() {
		return "admin/WL";
	}

	@RequestMapping(value = "/admin/WL", method = RequestMethod.POST)
	public @ResponseBody
	String deleteFromWL(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			// TODO: Add here validation
			if (ipAddress.contains(".")) {
				wlService.deleteIpV4FromWL(ipAddress);
				return "IpV4: " + ipAddress + " has been successfully deleted.";
			} else if (ipAddress.contains(":")) {
				wlService.deleteIpV4FromWL(ipAddress);
				return "IpV6: " + ipAddress + " has been successfully deleted.";
			} else {
				String response = "Some problems occurred with deleting IpAddress "
						+ ipAddress + " !!!";
				return response;
			}
		} catch (RuntimeException e) {
			// TODO: handle exception
			return "Where was error with deleting " + ipAddress + "!!!\n"
					+ e.toString();
		}
	}

	@RequestMapping(value = "/admin/AddIpToWL", method = RequestMethod.GET)
	public String addToWl() {
		return "admin/AddIpToWL";
	}

	@RequestMapping(value = "/admin/AddIpToWL", method = RequestMethod.POST)
	public @ResponseBody
	String addToWl(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			// TODO: Add here validation
			if (ipAddress.contains(".")) {
				wlService.addIpV4ToWL(ipAddress);
				return "IpV4: " + ipAddress
						+ " has been successfully added to WhiteList.";
			} else if (ipAddress.contains(":")) {
				wlService.addIpV6ToWL(ipAddress);
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

	@RequestMapping(value = "/secure/ShowIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWl() {
		return "secure/ShowIpListFromWL";
	}

	@RequestMapping(value = "/secure/ShowIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWl(Map<String, Object> map) {
		map.put("ipList", wlService.getIpV4ListFromWL());
		return "secure/listIpv4";
	}
}
