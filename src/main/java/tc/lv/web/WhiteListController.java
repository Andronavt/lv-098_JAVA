package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpV4Address;
import tc.lv.exceptions.WhiteListServiceException;
import tc.lv.service.WhiteListService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

@Controller
public class WhiteListController {

    @Autowired
    private WhiteListService whiteListService;

    // Delete IP-address from WhiteList
    @RequestMapping(value = "admin_deleteIpFromWL", method = RequestMethod.GET)
    public String deleteIpFromWhiteList() {
        return "admin_deleteIpFromWL";
    }

    // Delete IP-address from WhiteList
    @RequestMapping(value = "admin_deleteIpFromWL", method = RequestMethod.POST)
    public String deleteIpFromWhiteList(@ModelAttribute("address") String ipAddress, Map<String, Object> map) {

        try {
            if (IpValidator.isIpV4(ipAddress)) {
                return deleteIpFromDataBase(whiteListService.deleteIpV4ByName(ipAddress), ipAddress, map);
            }
            if (IpValidator.isIpV6(ipAddress)) {
                return deleteIpFromDataBase(whiteListService.deleteIpV6ByName(ipAddress), ipAddress, map);
            }
            map.put("incorrectMsg", "Incorrect IP-address!");
            return "result";

        } catch (WhiteListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

    // delete IP from DB
    private String deleteIpFromDataBase(boolean flag, String ipAddress, Map<String, Object> map)
            throws WhiteListServiceException {
        if (flag) {
            map.put("successMsg", "IP-address: " + ipAddress + " has been successfully deleted.");
            return "result";
        }
        map.put("incorrectMsg", "Current IP-address don't exist");
        return "result";
    }

    // Add IP-address to WhiteList
    @RequestMapping(value = "admin_addIpToWL", method = RequestMethod.GET)
    public String addIpToWhiteList() {
        return "admin_addIpToWL";
    }

    // Add IP-address to WhiteList
    @RequestMapping(value = "admin_addIpToWL", method = RequestMethod.POST)
    public String addIpToWhiteList(@ModelAttribute("address") String ipAddress, Map<String, Object> map) {
        try {
            if (IpValidator.isIpV4(ipAddress)) {
                return addIpToDataBase(whiteListService.saveIpV4ByName(ipAddress), ipAddress, map);
            }

            if (IpValidator.isIpV6(ipAddress)) {
                return addIpToDataBase(whiteListService.saveIpV6ByName(ipAddress), ipAddress, map);
            }

            map.put("incorrectMsg", "Incorrect IP-address!");
            return "result";

        } catch (WhiteListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
    }

    // add IP to DB
    private String addIpToDataBase(boolean flag, String ipAddress, Map<String, Object> map)
            throws WhiteListServiceException {
        if (flag) {
            map.put("successMsg", "IP-address: " + ipAddress + " has been successfully added to WhiteList.");
            return "result";
        }
        map.put("incorrectMsg", "Current IP-address exist");
        return "result";
    }

    // Show IP-address from WhiteList
    @RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.GET)
    public String showIpListFromWhiteList() {
        return "secure_showIpListFromWL";
    }

    @RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.POST)
    public String showIpListFromWhiteList(@ModelAttribute("page") String page,
            @ModelAttribute("value") String value, Map<String, Object> map) {
        try {
            List<IpV4Address> list = new ArrayList<IpV4Address>();
            list.addAll(whiteListService.loadIpV4ListByRange(
                    (Integer.parseInt(page) - 1) * Integer.parseInt(value), Integer.parseInt(value)));
            map.put("ipList", list);

        } catch (WhiteListServiceException e) {
            map.put("errorList", ExceptionUtil.createErrorList(e));
            map.put("errorMsg", e.getMessage());
            return "result";
        }
        return "secure_table";
    }
}