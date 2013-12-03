package tc.lv.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WhiteListMapController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_whiteListMap", method = RequestMethod.GET)
    public String deleteIpFromWhiteList() {
	return "secure_whiteListMap";
    }

}
