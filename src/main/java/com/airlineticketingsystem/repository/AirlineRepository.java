package com.airlineticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airlineticketingsystem.model.Airline;

public interface AirlineRepository  extends JpaRepository<Airline, Integer>{
	
	@Query("SELECT a FROM Airline a WHERE a.name LIKE ?1%")
	List<Airline> searchByName(String name);

}
