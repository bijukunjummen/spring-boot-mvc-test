package mvctest.web;

import mvctest.service.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hotels")
public class HotelController {
	private HotelRepository hotelRepository;
	
	@Autowired
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("hotels", this.hotelRepository.findAll());
		return "hotels/list";
	}
}
