package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//public class IndexController {
//    @RequestMapping(value = "/")
//    public String index() {
//	return "index";
//    }

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String contollContacts() {

		String message = "Hi, You are in Controller !!!";
		System.out.println(message);

		return "redirect:contacts.html";
	}
}
