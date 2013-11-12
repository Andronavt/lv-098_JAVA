package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InProgressController {

    @RequestMapping(value = "/inProgres")
    public String inProgress() {
	return "inProgres";
    }

}
