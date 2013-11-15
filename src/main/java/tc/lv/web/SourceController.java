package tc.lv.web;

import java.util.Map;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger
			.getLogger(SourceController.class);

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
			@ModelAttribute(value = "rank") String rank, Map<String, Object> map) {
		try {
			souService.addNewFeed(parser, sourceName, url, listType,
					Double.parseDouble(rank));
			map.put("successMsg", "Source " + sourceName
					+ " succesfuly addeed!");
			return "result";
		} catch (SourceServiseException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

	// Delete new sources
	@RequestMapping(value = "/deleteSource", method = RequestMethod.GET)
	public String deleteSourcePage(Map<String, Object> map)
			throws SourceServiseException {
		map.put("listSource", souService.getListOfSourcess());
		return "deleteSource";
	}

	// Delete new sources
	@RequestMapping(value = "/deleteSource", method = RequestMethod.POST)
	public String deleteSource(@ModelAttribute(value = "source") String source,
			Map<String, Object> map) {
		logger.info("Source delete.");
		try {
			souService.deleteFeed(source);
			map.put("successMsg", "Source " + source + " successfuly deletead!");
			return "result";
		} catch (SourceServiseException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

}
