package tc.lv.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tc.lv.domain.UserE;
@Controller
public class HeadController {
    @ModelAttribute
	public UserE populateCurrentUser(){
		return (UserE)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
   
    @RequestMapping(value = "/head")
    public String index() {
	return "head";
    }
     
    
    
    
}
