package mvctest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		return "hotels/home";
	}
	
}
