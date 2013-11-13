package tc.lv.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tc.lv.domain.UserEntity;

@Controller
public class HeadController {

    @ModelAttribute
    public UserEntity populateCurrentUser() {
	return (UserEntity) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
    }

    @RequestMapping(value = "/head")
    public String index() {
	return "head";
    }
}
