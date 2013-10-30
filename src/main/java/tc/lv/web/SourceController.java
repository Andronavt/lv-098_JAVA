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
    public String addContact(Map<String, Object> map, @RequestParam String sour) {
	map.put("ip", new Source());
	map.put("ipList",
		souService.getIpV4ListFromSource(Integer.valueOf(sour)));
	return "secure/TestGetIp4List";
    }

    @RequestMapping(value = "/admin/TestAddIpv4", method = RequestMethod.GET)
    public String addIplistPage() {
	return "admin/TestAddIpv4";
    }

    @RequestMapping(value = "/admin/TestAddIpv4", method = RequestMethod.POST)
    public @ResponseBody  String addUser(@ModelAttribute(value = "ip") String ip,
	    @ModelAttribute(value = "source") int source, BindingResult result) {
	String returnText;
	if (!result.hasErrors()) {
	    souService.setIpV4Address(ip, source);
	    returnText = "IP-address was added " + ip + " in source # " + source;
	} else {
	    returnText = "Sorry, an error has occur. IP-address has not been added to source.";
	}
	return returnText;
    }

    // @RequestMapping(value = "/admin/addIpv4", method=RequestMethod.POST )
    // public String testAction(@RequestParam String ip, @RequestParam int
    // source, Model model) {
    // // System.out.println("test");
    // model.addAttribute("added_ip", ip);
    // model.addAttribute("added_source", source);
    // //souService.setIpV4Address(ip, source);
    // return "admin/TestAddIpv4";// "admin/TestAddIpv4";
    // }
}
