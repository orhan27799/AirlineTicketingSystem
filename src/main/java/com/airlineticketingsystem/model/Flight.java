package com.airlineticketingsystem.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private Integer capacity;

	private Double price;
	
	private String flightNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrivalDate;

	private String departureTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_id")
	private Airline airline;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "route_id")
	private Route route;
	
	public Flight() {
		super();
	}

	public Flight(String name, Integer capacity, Double price,String flightNumber,LocalDate departureDate,LocalDate arrivalDate,String departureTime) {
		super();
		this.name=name;
		this.capacity=capacity;
		this.price=price;
		this.flightNumber=flightNumber;
		this.departureDate=departureDate;
		this.arrivalDate=arrivalDate;
		this.departureTime=departureTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	


}
