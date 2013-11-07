package tc.lv.web;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.service.SourceService;

@Controller
public class SourceController {

	private static int SOURCE_TEST = 1;
	private static final Logger logger = Logger.getLogger("infoLog");
	@Autowired
	private SourceService souService;

	// Get IPv4 List from Source -- get jsp
	@RequestMapping("/getIpV4List")
	public String getlistIpV4(Map<String, Object> map) {
		logger.info("getting secure/GetIp4List.jsp");
		map.put("listSource", souService.getListOfSourcess());
		return "getIpV4List";
	}
	// Get IPv4 List from Source -- get data from form
	@RequestMapping(value = "listIpV4", method = RequestMethod.POST)
	public String addContact(Map<String, Object> map,
			@ModelAttribute(value = "source") String source,
			BindingResult result) {
		logger.info("getting List of IPv4 and sending to secure/listIpv4");
		map.put("source", source);
		map.put("ipList",
				souService.getIpV4ListFromSource(Integer.valueOf(source)));
		return "listIpV4";
	}

	// Add IPv4 to Source -- get jsp
	@RequestMapping(value = "/addIpv4", method = RequestMethod.GET)
	public String addIplistPage(Map<String, Object> map) {
		logger.info("getting admin/AddIpv4.jsp");
		map.put("listSource", souService.getListOfSourcess());
		return "addIpv4";
	}
	// Add IPv4 to Source -- get data from form
	@RequestMapping(value = "/addIpv4", method = RequestMethod.POST)
	public @ResponseBody
	String addUser(@ModelAttribute(value = "ip") String ip,
			@ModelAttribute(value = "source") int source, BindingResult result) {
		String returnText;
		logger.info("getting IP-adress from form");
		if (!result.hasErrors()) {
			logger.info("sending data to DataBase");
			souService.setIpV4Address(ip, source);
			returnText = "IP-address was added " + ip + " in source # "
					+ source;
		} else {
			returnText = "Sorry, an error has occur. IP-address has not been added to source.";
			logger.info("Error. IP address not added to DataBase");
		}
		return returnText;
	}

	// Add new sources
	@RequestMapping(value = "/addNewFeed", method = RequestMethod.GET)
	public String newFeed() {
		return "addNewFeed";
	}

	@RequestMapping(value = "/addNewFeed", method = RequestMethod.POST)
	public String addNew(@RequestParam String typeOfList,
			@RequestParam String rankOfSource, @RequestParam String sourceName,
			@RequestParam String url) {
		souService.addNewFeed(typeOfList, rankOfSource, sourceName, url);
		return "addNewFeed";
	}

	@RequestMapping(value = "/listOfSource", method = RequestMethod.POST)
	public String deleteSource(@ModelAttribute(value = "source") String source) {
		souService.deleteFeed(source);
		return "listOfSource";
	}

	@RequestMapping(value = "/listOfSource", method = RequestMethod.GET)
	public String listOfSources(Map<String, Object> map) {
		map.put("listSource", souService.getListOfSourcess());
		return "listOfSource";
	}

}
