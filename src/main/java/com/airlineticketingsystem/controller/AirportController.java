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

import com.airlineticketingsystem.model.Airport;
import com.airlineticketingsystem.repository.AirportRepository;

@Controller
public class AirportController {

	@Autowired
	AirportRepository airportRepository;

	@PostMapping("/airport/add")
	@ResponseBody
	public String saveAirport(@RequestBody Airport airport, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "error";
		}
		airportRepository.save(airport);

		return "success";
	}
	
	    @GetMapping("/airport/search")
	    @ResponseBody
	    public  List<Airport> viewHomePage(Model model, @Param("name") String name) {
	        List<Airport> listAirport = airportRepository.searchByName(name);
	      
	         
	        return listAirport;
	    }
	
	
	

}
