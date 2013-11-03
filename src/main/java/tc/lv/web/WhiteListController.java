package tc.lv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.service.WhiteListService;

@Controller
@RequestMapping("/admin")
public class WhiteListController {
	@Autowired
	private WhiteListService wlService;

	@RequestMapping(value = "/WL", method = RequestMethod.GET)
	public String deleteFromWL() {
		return "admin/WL";
	}

	@RequestMapping(value = "/WL", method = RequestMethod.POST)
	public @ResponseBody
	String deleteFromWL(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			//TODO: Add here validation
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

	@RequestMapping(value = "/AddIpToWL", method = RequestMethod.GET)
	public String addToWl() {
		return "admin/AddIpToWL";
	}

	@RequestMapping(value = "/AddIpToWL", method = RequestMethod.POST)
	public @ResponseBody
	String addToWl(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			//TODO: Add here validation
			if (ipAddress.contains(".")) {
				wlService.addIpV4toWL(ipAddress);
				return "IpV4: " + ipAddress
						+ " has been successfully added to WhiteList.";
			} else if (ipAddress.contains(":")) {
				wlService.addIpV6toWL(ipAddress);
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
}
