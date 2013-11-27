package tc.lv.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InProgressController {
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_inProgres")
    public String inProgress() {
        return "secure_inProgres";
    }

}
