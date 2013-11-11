package tc.lv.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.exceptions.DBCreateUserException;
import tc.lv.exceptions.UserValidationException;
import tc.lv.service.UserEntityService;
import tc.lv.utils.UserValidator;

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
	    @ModelAttribute(value = "pass") String pass)
	    throws DBCreateUserException, UserValidationException {
	if (UserValidator.isCorrectName(user_name)
		&& UserValidator.isCorrectFirstName(first_name)
		&& UserValidator.isCorrectLastName(last_name)
		&& UserValidator.isCorrectEmail(email)
		&& UserValidator.isCorrectPassword(pass)) {
	    userEntityService.addCustomerUser(user_name, first_name, last_name,
		    email, pass);
	    return "User was registred";
	} else {
	    throw new UserValidationException(
		    "Inccorect data for registration!");
	}
    }
}
