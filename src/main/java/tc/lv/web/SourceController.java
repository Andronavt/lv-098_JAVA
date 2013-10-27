package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tc.lv.dao.SourceDaoImpl;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;
import tc.lv.domain.User;
import tc.lv.service.SourceService;
import tc.lv.service.UserService;

@Controller
public class SourceController {

	private static final int SOURCE_TEST = 1;

	@Autowired
	private SourceService souService;
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String listIpV4(Map<String, Object> map) {
		map.put("ip", new Source());
		map.put("ipList", souService.getIpV4ListFromSource(SOURCE_TEST));
//		List<IpV4Address> list = new ArrayList<IpV4Address>();
//		souService.setIpV4Address("1111", SOURCE_TEST);
		
		User a = userService.getUserByName("admin");
		System.out.println(a.getName()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return "ip";
	}
}
