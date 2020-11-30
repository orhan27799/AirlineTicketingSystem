package com.airlineticketingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airlineticketingsystem.model.Flight;
import com.airlineticketingsystem.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;

	@PostMapping("/flight/add")
	@ResponseBody
	public String saveFlight(@RequestBody Flight flight, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "error";
		}
		flightRepository.save(flight);

		return "success";
	}
	
	    @GetMapping("/flight/list")
	    @ResponseBody
	    public  List<Flight> searhFlight(Model model) {
	        List<Flight> listFlight = flightRepository.findAll();
	      
	         
	        return listFlight;
	    }
	
	    @GetMapping("/flight/search")
	    @ResponseBody
	    public  List<Flight> searhFlight(Model model, @Param("name") String name) {
	        List<Flight> listFlight = flightRepository.searchByName(name);
	      
	         
	        return listFlight;
	    }
	
	

}
