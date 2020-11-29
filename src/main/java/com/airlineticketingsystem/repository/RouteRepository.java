package com.airlineticketingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airlineticketingsystem.model.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {
	
	@Query("SELECT r FROM Route r WHERE r.name LIKE %?1%")
	List<Route> searchByName(String name);

}
