package tc.lv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tc.lv.exceptions.*;
import tc.lv.service.UserEntityService;

@Controller
public class RegistrationController {
	@Autowired
	private UserEntityService userEntityService;

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String registration() {
		return "user/registration";
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)

	public @ResponseBody
	String addUser(@ModelAttribute(value = "user_name") String user_name,
			@ModelAttribute(value = "first_name") String first_name,
			@ModelAttribute(value = "last_name") String last_name,
			@ModelAttribute(value = "email") String email,
			@ModelAttribute(value = "pass") String pass, BindingResult result) {
		String returnText;

		if (user_name.trim() == "") {
			return "NoT";
		} else {
			if (!result.hasErrors()) {
				userEntityService.addCustomerUser(user_name, first_name,
						last_name, email, pass);
				return "Success";
			} else {
				returnText = "Sorry, an error has occur.";
			}
			return returnText;
		}
	}
}
