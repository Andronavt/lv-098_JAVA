package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.exceptions.UserEntityServiceException;
import tc.lv.service.UserEntityService;
import tc.lv.utils.ExceptionUtil;
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
    public String addUser(
	    @ModelAttribute(value = "user_name") String user_name,
	    @ModelAttribute(value = "first_name") String first_name,
	    @ModelAttribute(value = "last_name") String last_name,
	    @ModelAttribute(value = "e-mail") String email,
	    @ModelAttribute(value = "pass") String pass, Map<String, Object> map) {
	try {
	    if (UserValidator.isCorrectName(user_name)
		    && UserValidator.isCorrectFirstName(first_name)
		    && UserValidator.isCorrectLastName(last_name)
		    && UserValidator.isCorrectEmail(email)
		    && UserValidator.isCorrectPassword(pass)) {
		userEntityService.createUser(user_name, first_name, last_name,
			email, pass);
		map.put("successMsg", "User was registred");
		return "result";
	    } else {
		throw new UserEntityServiceException(
			"Inccorect data for registration!");
	    }
	} catch (UserEntityServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
    }
}
