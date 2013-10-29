package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addContact(Map<String, Object> map, @RequestParam String sour) {
	map.put("ip", new Source());
	map.put("ipList",
		souService.getIpV4ListFromSource(Integer.valueOf(sour)));
	return "secure/TestGetIp4List";
    }

    @RequestMapping("/admin/TestAddIpv4")
    public String addIplist() {
	return "admin/TestAddIpv4";
    }

    @RequestMapping("/admin/addIpv4")
    public String testAction(@RequestParam String ip, @RequestParam int source,
	    Model model) {
	model.addAttribute("added_ip", ip);
	model.addAttribute("added_source", source);
	souService.setIpV4Address(ip, source);
	return "admin/TestAddIpv4";
    }
}
