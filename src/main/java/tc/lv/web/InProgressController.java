package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InProgressController {

    @RequestMapping(value = "secure_inProgres")
    public String inProgress() {
        return "secure_inProgres";
    }

}
