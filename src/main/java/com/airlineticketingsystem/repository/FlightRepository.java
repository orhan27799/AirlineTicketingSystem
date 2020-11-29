package com.airlineticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airlineticketingsystem.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	@Query("SELECT f FROM Flight f WHERE f.name LIKE %?1%")
	List<Flight> searchByName(String name);

}
