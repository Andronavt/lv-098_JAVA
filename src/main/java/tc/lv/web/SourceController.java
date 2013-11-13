package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.exceptions.SourceServiseException;
import tc.lv.service.SourceService;
import tc.lv.utils.ExceptionUtil;

@Controller
public class SourceController {

	@Autowired
	private SourceService souService;

	// Add new sources
	@RequestMapping(value = "addNewFeed", method = RequestMethod.GET)
	public String addNewFeedPage() {
		return "addNewFeed";
	}

	// Add new sources
	@RequestMapping(value = "/addNewFeed", method = RequestMethod.POST)
	public String addNewFeed(@ModelAttribute(value = "parser") String parser,
			@ModelAttribute(value = "sourceName") String sourceName,
			@ModelAttribute(value = "url") String url,
			@ModelAttribute(value = "listType") String listType,
			@ModelAttribute(value = "rank") String rank, 
			Map<String, Object> map) {
		try {
			souService.addNewFeed(parser, sourceName, url, listType,
					Double.parseDouble(rank));
			return "result";
		} catch (SourceServiseException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

	// Delete new sources
	@RequestMapping(value = "/listOfSource", method = RequestMethod.GET)
	public String deleteSourcePage(Map<String, Object> map)
			throws SourceServiseException {
		map.put("listSource", souService.getListOfSourcess());
		return "listOfSource";
	}

	// Delete new sources
	@RequestMapping(value = "/listOfSurce", method = RequestMethod.POST)
	public String deleteSource(@ModelAttribute(value = "source") String source,
			Map<String, Object> map) {
		try {
			souService.deleteFeed(source);
			return "listOfSource";
		} catch (SourceServiseException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

}
