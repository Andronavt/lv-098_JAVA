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
@RequestMapping(value = "/deleteIpFrom")
public class WhiteListController {
	@Autowired
	private WhiteListService wlService;

	@RequestMapping(value = "/WL", method = RequestMethod.GET)
	public String getJSP() {
		return "deleteIpFrom/WL";
	}

	@RequestMapping(value = "/WL", method = RequestMethod.POST)
	public @ResponseBody
	String addUser(@ModelAttribute("address") String ipAddress,
			BindingResult result) {
		try {
			// System.err.println(ipAddress);
			if (ipAddress.contains(".")) {
				wlService.deleteIpV4FromWL(ipAddress);
				return "IpV4: " + ipAddress + " has been successfully deleted.";
			} else if (ipAddress.contains(":")) {
				wlService.deleteIpV4FromWL(ipAddress);
				return "IpV6: " + ipAddress + " has been successfully deleted.";
			} else {
				String response = "Some problems occurred with IpAddress "
						+ ipAddress + " !!!";
				return response;
			}
		} catch (RuntimeException e) {
			// TODO: handle exception
			return "Where was error whit deleting " + ipAddress + "!!!\n"
					+ e.toString();
		}
	}

}
