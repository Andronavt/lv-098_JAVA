package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SigninController {
<<<<<<< HEAD
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {
		return "signin";
	}

	@RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
	public String signinFailure() {
		return "signinFailure";
	}
=======
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
	return "signin";
    }

    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure() {
	return "signinFailure";
    }
>>>>>>> 362cec57dcceece1c58bdc48eb73cc759bfd2045
}
