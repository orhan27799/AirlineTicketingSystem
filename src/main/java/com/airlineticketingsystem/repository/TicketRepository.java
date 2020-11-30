package com.airlineticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airlineticketingsystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	@Query("SELECT t FROM Ticket t WHERE t.number= ?1")
	List<Ticket> searchByNumber(Integer number);

}
