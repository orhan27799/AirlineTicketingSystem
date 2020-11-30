package com.airlineticketingsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airlineticketingsystem.model.Airline;
import com.airlineticketingsystem.model.Flight;
import com.airlineticketingsystem.model.Ticket;
import com.airlineticketingsystem.repository.AirlineRepository;
import com.airlineticketingsystem.repository.FlightRepository;
import com.airlineticketingsystem.repository.TicketRepository;

@Controller
public class TickectController {
	
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	FlightRepository flightRepository;

	@PostMapping("/ticket/add")
	@ResponseBody
	public String saveTicket(@RequestBody Ticket airline, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "error";
		}
		ticketRepository.save(airline);

		return "success";
	}
	
	    @GetMapping("/ticket/search")
	    @ResponseBody
	    public  List<Ticket> searchTicket(Model model, @Param("number") Integer number) {
	        List<Ticket> tickets = ticketRepository.searchByNumber(number); 
	        
	        for (Ticket ticket : tickets) {
	        	ticket.setCreditCardNumber(creditcardMasker(ticket.getCreditCardNumber()));;
				
			}
	      
	         
	        return tickets;
	    }
	    
	    

	
		@GetMapping("/ticket/list")
	    @ResponseBody
	    public  List<Ticket> listTicket(Model model) {
	        List<Ticket> tickets = ticketRepository.findAll();
	        
	        for (Ticket ticket : tickets) {
	        	ticket.setCreditCardNumber(creditcardMasker(ticket.getCreditCardNumber()));;
				
			}
	      
	        return tickets;
	    }
	    
	private String creditcardMasker(String creditCardNumber) {
		int total = creditCardNumber.length();
		int startlen = 4, endlen = 4;
		int masklen = total - (startlen + endlen);
		StringBuffer maskedbuf = new StringBuffer(creditCardNumber.substring(0, startlen));
		for (int i = 0; i < masklen; i++) {
			maskedbuf.append('*');
		}
		maskedbuf.append(creditCardNumber.substring(startlen + masklen, total));
		String masked = maskedbuf.toString();
		
		return masked;
	}
	    
	    @GetMapping("/ticket/available")
	    @ResponseBody
	    public  List<Ticket> searchList(Model model) {
	    	
	        List<Flight> flights = flightRepository.findAll();
	        List<Ticket> tickets=new ArrayList<Ticket>();
	       
	        if(!flights.isEmpty()) {
	        	for (Flight flight : flights) {
	        		 Integer flightCount=flightRepository.countById(flight.getId());
	        		 if(flight.getCapacity()>flightCount) {
	        			 Ticket ticket=createTicket(flight,flightCount);
	        			 tickets.add(ticket);
	        		 }
					
				}
	        	
	        }
	      
	         
	        return tickets;
	    }

		private Ticket createTicket(Flight flight, Integer flightCount) {
			Ticket ticket=new Ticket();
			ticket.setFlight(flight);
			ticket.setNumber((int) (Math.random()*100000));
			ticket.setPrice(calculatePrice(flightCount,flight.getCapacity(),flight.getPrice()));
			return ticket;
		}

		private Double calculatePrice(Integer flightCount, Integer capacity, Double price) {
			int pertentage=(flightCount*10)/capacity;
			if(pertentage>=1) {
				for (int i = 0; i < pertentage; i++) {
					price+=price/10;
				}
			}
			return price;
		}
	
	
	@DeleteMapping("/ticket/cancel")
	@ResponseBody
	public String ticketCancel(Model model, @Param("ticketId") Integer ticketId) {
		Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
		if (ticket == null) {
			return "ticket not found";
		}

		ticketRepository.delete(ticket);
		return "ticket canceled";
	}

}
