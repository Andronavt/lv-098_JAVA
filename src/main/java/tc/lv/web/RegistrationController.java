package tc.lv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.exceptions.DBCreateUserException;
import tc.lv.service.UserEntityService;

@Controller
public class RegistrationController {
	@Autowired
	private UserEntityService userEntityService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public @ResponseBody
	String addUser(@ModelAttribute(value = "user_name") String user_name,
			@ModelAttribute(value = "first_name") String first_name,
			@ModelAttribute(value = "last_name") String last_name,
			@ModelAttribute(value = "email") String email,
			@ModelAttribute(value = "pass") String pass, BindingResult result) {
		String returnText;
		if (!result.hasErrors()) {
			try {
				userEntityService.addCustomerUser(user_name, first_name,
						last_name, email, pass);
			} catch (DBCreateUserException e) {
				e.printStackTrace();
			}
			return "Success";
		} else {
			returnText = "Sorry, an error has occur.";
		}
		return returnText;
	}
}
