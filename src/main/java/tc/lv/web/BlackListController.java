package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.exceptions.BlackListServiceException;
import tc.lv.service.BlackListService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    // Delete IP-address from BlackList
    @RequestMapping(value = "admin_deleteIpFromBL", method = RequestMethod.GET)
    public String deleteIpFromBlackList() {
        return "admin_deleteIpFromBL";
    }

    // Delete IP-address from BlackList
    @RequestMapping(value = "admin_deleteIpFromBL", method = RequestMethod.POST)
    public String deleteIpFromBlackList(@ModelAttribute("address") String ipAddress, Map<String, Object> map) {
        try {
            if (IpValidator.isIpV4(ipAddress)) {
                return deleteIpFromDataBase(blackListService.deleteIpV4ByName(ipAddress), ipAddress, map);
            }
            if (IpValidator.isIpV6(ipAddress)) {
                return deleteIpFromDataBase(blackListService.deleteIpV6ByName(ipAddress), ipAddress, map);
            }
            map.put("incorrectMsg", "Incorrect IP-address!");
            return "result";

        } catch (BlackListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

    // delete IP from DB
    private String deleteIpFromDataBase(boolean flag, String ipAddress, Map<String, Object> map)
            throws BlackListServiceException {
        if (flag) {
            map.put("successMsg", "IP-address: " + ipAddress + " has been successfully deleted.");
            return "result";
        }
        map.put("incorrectMsg", "Current IP-address don't exist");
        return "result";
    }

    // Add IP-address from BlackList
    @RequestMapping(value = "admin_addIpToBL", method = RequestMethod.GET)
    public String addIpToBlackList() {
        return "admin_addIpToBL";
    }

    // Add IP-address from BlackList
    @RequestMapping(value = "admin_addIpToBL", method = RequestMethod.POST)
    public @ResponseBody
    String addIpToBlackList(@ModelAttribute("address") String ipAddress, Map<String, Object> map) {
        try {
            if (IpValidator.isIpV4(ipAddress)) {
                return addIpToDataBase(blackListService.saveIpV4ByName(ipAddress), ipAddress, map);
            }
            if (IpValidator.isIpV6(ipAddress)) {
                return addIpToDataBase(blackListService.saveIpV6ByName(ipAddress), ipAddress, map);
            }
            map.put("incorrectMsg", "Incorrect IP-address!");
            return "result";

        } catch (BlackListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }

    }

    // add IP to DB
    private String addIpToDataBase(boolean flag, String ipAddress, Map<String, Object> map)
            throws BlackListServiceException {
        if (flag) {
            map.put("successMsg", "IP-address: " + ipAddress + " has been successfully added to BlackList.");
            return "result";
        }
        map.put("incorrectMsg", "Current IP-address exist");
        return "result";
    }

    // Show IP-address from BlackList
    @RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.GET)
    public String showIpListFromBlackList() {
        return "secure_showIpListFromBL";
    }

    // Show IP-address from BlackList
    @RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.POST)
    public String showIpListFromBlackList(Map<String, Object> map) {
        try {
            map.put("ipList", blackListService.loadIpV4List());
            return "secure_showIpListFromBL"; // Need create alone jsp-page

        } catch (BlackListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }
}
