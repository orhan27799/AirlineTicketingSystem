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
import com.airlineticketingsystem.model.Airport;
import com.airlineticketingsystem.model.Route;
import com.airlineticketingsystem.repository.AirlineRepository;
import com.airlineticketingsystem.repository.AirportRepository;
import com.airlineticketingsystem.repository.RouteRepository;

@Controller
public class RouteController {

	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	AirlineRepository  airlineRepository;
	
	@Autowired
	AirportRepository airportRepository;

	@PostMapping("/route/add")
	@ResponseBody
	public String saveRoute(@RequestBody Route route, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "error"; 
		}
		Airline airline=airlineRepository.findById(route.getAirline().getId()).orElse(null);
		Airport departureAirport=airportRepository.findById(route.getDepartureAirport().getId()).orElse(null);
		Airport destinationAirport=airportRepository.findById(route.getDestinationAirport().getId()).orElse(null);
        route.setAirline(airline);
        route.setDepartureAirport(departureAirport);
        route.setDestinationAirport(destinationAirport);
		routeRepository.save(route);

		return "success";
	}

	@GetMapping("/route/search")
	@ResponseBody
	public List<Route> searchRoute(Model model, @Param("name") String name) {
		List<Route> listRoute = routeRepository.searchByName(name);

		return listRoute;
	}

}
