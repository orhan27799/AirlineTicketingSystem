package com.airlineticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airlineticketingsystem.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	
	@Query("SELECT a FROM Airport a WHERE a.name LIKE ?1%")
	List<Airport> searchByName(String name);

}
