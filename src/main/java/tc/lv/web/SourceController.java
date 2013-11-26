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

    private static final Logger LOGGER = Logger.getLogger(SourceController.class);

    @Autowired
    private SourceService sourceService;

    // Add new sources
    @RequestMapping(value = "admin_addNewSource", method = RequestMethod.GET)
    public String addNewFeedPage() {
        return "admin_addNewSource";
    }

    // Add new sources
    @RequestMapping(value = "admin_addNewSource", method = RequestMethod.POST)
    public String addNewFeed(@ModelAttribute(value = "parser") String parser,
            @ModelAttribute(value = "sourceName") String sourceName, @ModelAttribute(value = "url") String url,
            @ModelAttribute(value = "listType") String listType, @ModelAttribute(value = "rank") String rank,
            Map<String, Object> map) {
	
        try {
            if (sourceService.addNewFeed(parser, sourceName, url, listType, Double.parseDouble(rank))) {
                map.put("successMsg", "Source " + sourceName + " succesfuly addeed!");
                return "result";
            }
            map.put("incorrectMsg", "Current Feed exist!");
            return "result";

        } catch (SourceServiseException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

    // Delete new sources
    @RequestMapping(value = "admin_deleteSource", method = RequestMethod.GET)
    public String deleteSourcePage(Map<String, Object> map) throws SourceServiseException {
        map.put("listSource", sourceService.getListOfSourcess());
        return "admin_deleteSource";
    }

    // Delete new sources
    @RequestMapping(value = "admin_deleteSource", method = RequestMethod.POST)
    public String deleteSource(@ModelAttribute(value = "source") String source, Map<String, Object> map) {
        LOGGER.info("Source delete.");
        try {
            if (sourceService.deleteFeedByName(source)) {
                map.put("successMsg", "Source " + source + " successfuly deletead!");
                return "result";
            }
            map.put("incorrectMsg", "Could not found this feed for delete!");
            return "result";

        } catch (SourceServiseException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

}
