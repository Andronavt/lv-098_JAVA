package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.exceptions.SourceServiseException;
import tc.lv.service.SourceService;

@Controller
public class SourceController {

	@Autowired
	private SourceService souService;

	// Get IPv4 List from Source -- get jsp
	@RequestMapping("getIp4List")
	public String getlistIpV4Page(Map<String, Object> map)
			throws SourceServiseException {
		try {
			map.put("listSource", souService.getListOfSourcess());
			return "getIp4List";
		} catch (Exception e) {
			throw new SourceServiseException("Could not put in map", e);
		}
	}
	// Get IPv4 List from Source -- get data from form
	// Fix on UI
	// @RequestMapping(value = "listIpv4", method = RequestMethod.POST)
	// public String getlistIpV4(Map<String, Object> map,
	// @ModelAttribute(value = "source") String source,
	// BindingResult result) throws SourceServiseException {
	// map.put("source", source);
	// map.put("ipList",
	// souService.getIpV4ListFromSource(Integer.valueOf(source)));
	// return "listIpv4";
	// }

	// Add new sources
	@RequestMapping(value = "addNewFeed", method = RequestMethod.GET)
	public String addNewFeedPage() {
		return "addNewFeed";
	}

	@RequestMapping(value = "/newFeed", method = RequestMethod.POST)
	public String addNewFeed(@ModelAttribute(value = "parser") String parser,
			@ModelAttribute(value = "sourceName") String sourceName,
			@ModelAttribute(value = "url") String url,
			@ModelAttribute(value = "listType") String listType,
			@ModelAttribute(value = "rank") String rank)
			throws SourceServiseException {
		try {
			souService.addNewFeed(parser, sourceName, url, listType,
					Double.parseDouble(rank));
			return "addNewFeed";
		} catch (Exception e) {
			throw new SourceServiseException("Could not add new feed", e);
		}
	}

	@RequestMapping(value = "/listOfSource", method = RequestMethod.GET)
	public String deleteSourcePage(Map<String, Object> map)
			throws SourceServiseException {
		map.put("listSource", souService.getListOfSourcess());
		return "listOfSource";
	}

	@RequestMapping(value = "/listOfSurce", method = RequestMethod.POST)
	public String deleteSource(@ModelAttribute(value = "source") String source)
			throws SourceServiseException {
		try {
			souService.deleteFeed(source);
			return "listOfSource";
		} catch (Exception e) {
			throw new SourceServiseException("Could not delete new feed", e);
		}
	}

}
