package app.cal.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {
	
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getLandingPage() {
		return "product";
	}

	@RequestMapping(value="/enrollProduct", method=RequestMethod.GET)
	public String enrollProduct( @RequestParam(value="refId", required=true) String refId, ModelMap modelMap) {
		modelMap.addAttribute("refId", refId);
		return "enrollProduct";
	}
}
