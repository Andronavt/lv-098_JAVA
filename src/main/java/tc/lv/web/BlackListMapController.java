package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlackListMapController {

    @RequestMapping(value = "secure_blackListMap", method = RequestMethod.GET)
    public String deleteIpFromWhiteList() {
        return "secure_blackListMap";
    }
    
}
