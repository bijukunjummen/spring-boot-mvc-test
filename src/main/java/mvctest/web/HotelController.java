package mvctest.web;

import javax.validation.Valid;

import mvctest.domain.Hotel;
import mvctest.service.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/hotels")
public class HotelController {
	private HotelRepository hotelRepository;
	
	@Autowired
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("hotels", this.hotelRepository.findAll());
		return "hotels/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model) {
		model.addAttribute("hotel", this.hotelRepository.findOne(id));
		return "hotels/edit";
	}
	
	@RequestMapping(method=RequestMethod.GET, params="form")
	public String createForm(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotels/create";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Hotel hotel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "hotels/create";
		}else {
			this.hotelRepository.save(hotel);
			return "redirect:/hotels";
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@Valid Hotel hotel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "hotels/edit";
		}else {
			hotelRepository.save(hotel);
			return "redirect:/hotels";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		this.hotelRepository.delete(id);
		return "redirect:/hotels";
	}
}
