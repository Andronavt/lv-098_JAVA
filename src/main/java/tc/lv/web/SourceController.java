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

import tc.lv.exceptions.DBCreateSourceException;
import tc.lv.service.SourceService;
import tc.lv.utils.IpValidator;

@Controller
public class SourceController {

	@Autowired
	private SourceService souService;

	// Get IPv4 List from Source -- get jsp
	@RequestMapping("getIp4List")
	public String getlistIpV4Page(Map<String, Object> map) {
		map.put("listSource", souService.getListOfSourcess());
		return "getIp4List";
	}
	// Get IPv4 List from Source -- get data from form
	@RequestMapping(value = "listIpv4", method = RequestMethod.POST)
	public String getlistIpV4(Map<String, Object> map,
			@ModelAttribute(value = "source") String source,
			BindingResult result) {
		map.put("source", source);
		map.put("ipList",
				souService.getIpV4ListFromSource(Integer.valueOf(source)));
		return "listIpv4";
	}

	// Add new sources
	@RequestMapping(value = "addNewFeed", method = RequestMethod.GET)
	public String addNewFeedPage() {
		return "addNewFeed";
	}

	@RequestMapping(value = "/newFeed", method = RequestMethod.POST)
	public String addNewFeed(@RequestParam String typeOfList,
			@RequestParam String rankOfSource, @RequestParam String sourceName,
			@RequestParam String url) {

		try {
			souService.addNewFeed("C:!!!!!!!111",typeOfList, Double.parseDouble(rankOfSource), sourceName);
		} catch (DBCreateSourceException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "addNewFeed";
	}

	

	@RequestMapping(value = "/listOfSource", method = RequestMethod.GET)
	public String deleteSourcePage(Map<String, Object> map) {
		map.put("listSource", souService.getListOfSourcess());
		return "listOfSource";
	}
	@RequestMapping(value = "/listOfSurce", method = RequestMethod.POST)
	public String deleteSource(@ModelAttribute(value = "source") String source) {
		souService.deleteFeed(source);
		return "listOfSource";
	}

}
