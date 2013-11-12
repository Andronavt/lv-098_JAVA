<<<<<<< HEAD
package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/welcomes")
	public String index() {
		return "welcome";
	}
}
=======
package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/welcomes")
    public String index() {
	return "welcome";
    }
}
>>>>>>> 4fbc0858ea1b4f17d6b64a6e915bb10be72b4566
