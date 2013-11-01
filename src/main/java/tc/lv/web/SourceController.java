package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.domain.Source;
import tc.lv.service.SourceService;

@Controller
public class SourceController {

	private static int SOURCE_TEST = 1;

	@Autowired
	private SourceService souService;

	@RequestMapping("/ip")
	public String listIpV4(Map<String, Object> map) {
		map.put("ip", new Source());
		map.put("ipList", souService.getIpV4ListFromSource(SOURCE_TEST));
		return "ip";
	}

	@RequestMapping("/secure/TestGetIp4List")
	public String getlistIpV4() {
		return "secure/TestGetIp4List";
	}

	@RequestMapping(value = "/secure/getList")
	public String addContact(Map<String, Object> map,
			@ModelAttribute(value = "sour") String sour, BindingResult result) {
		map.put("ip", new Source());
		map.put("ipList",
				souService.getIpV4ListFromSource(Integer.valueOf(sour)));
		return "secure/listIpv4";
	}

	@RequestMapping(value = "/admin/AddIpv4", method = RequestMethod.GET)
	public String addIplistPage() {
		return "admin/AddIpv4";
	}

	@RequestMapping(value = "/admin/AddIpv4", method = RequestMethod.POST)
	public @ResponseBody
	String addUser(@ModelAttribute(value = "ip") String ip,
			@ModelAttribute(value = "source") int source, BindingResult result) {
		String returnText;
		if (!result.hasErrors()) {
			souService.setIpV4Address(ip, source);
			returnText = "IP-address was added " + ip + " in source # "
					+ source;
		} else {
			returnText = "Sorry, an error has occur. IP-address has not been added to source.";
		}
		return returnText;
	}

	// Add new sources
	@RequestMapping(value = "admin/AddNewFeed", method = RequestMethod.GET)
	public String newFeed() {
		return "admin/AddNewFeed";
	}

	@RequestMapping(value = "/newFeed", method = RequestMethod.POST)
	public String addNew(@RequestParam String adaptor,
			@RequestParam String typeOfList, @RequestParam String rankOfSource,
			@RequestParam String sourceName, @RequestParam String url) {
		souService.addNewFeed(adaptor, typeOfList, rankOfSource, sourceName,
				url);
		return "admin/AddNewFeed";
	}

	// deleting source
	@RequestMapping(value = "/deleteSource", method = RequestMethod.POST)
	public String deleteSource(
			@ModelAttribute("deleteSource") String sourceForDeleting) {
		souService.deleteFeed(sourceForDeleting);
		return "admin/listOfSurce";
	}

	@RequestMapping("/formListOfSources")
	public String listOfSources(Map<String, Object> map) {
		map.put("listSource", souService.getListOfSourcess());
		return "admin/listOfSource";
	}

	@RequestMapping(value = "admin/listOfSource", method = RequestMethod.GET)
	public String getListOfSource() {
		return "admin/listOfSource";
	}

}