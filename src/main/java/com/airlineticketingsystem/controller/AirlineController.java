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

import com.airlineticketingsystem.model.Airline;
import com.airlineticketingsystem.repository.AirlineRepository;

@Controller
public class AirlineController {

	@Autowired
	AirlineRepository airlineRepository;

	@PostMapping("/airline/add")
	@ResponseBody
	public String saveAirport(@RequestBody Airline airline, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "error";
		}
		airlineRepository.save(airline);

		return "success";
	}
	
	    @GetMapping("/airline/search")
	    @ResponseBody
	    public  List<Airline> viewHomePage(Model model, @Param("name") String name) {
	        List<Airline> listAirline = airlineRepository.searchByName(name);
	      
	         
	        return listAirline;
	    }
	
	
	

}