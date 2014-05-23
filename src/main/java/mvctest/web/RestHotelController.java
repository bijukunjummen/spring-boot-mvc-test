package mvctest.web;

import java.util.List;

import javax.validation.Valid;

import mvctest.domain.Hotel;
import mvctest.service.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hotels")
public class RestHotelController {
	private HotelRepository hotelRepository;
	
	@Autowired
	public RestHotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Hotel create(@RequestBody @Valid Hotel hotel) {
		return this.hotelRepository.save(hotel);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Hotel> list() {
		return this.hotelRepository.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Hotel get(@PathVariable("id") long id) {
		return this.hotelRepository.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Hotel update(@PathVariable("id") long id, @RequestBody @Valid Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		this.hotelRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
