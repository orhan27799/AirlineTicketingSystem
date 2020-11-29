package com.airlineticketingsystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "airport")
public class Airport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String iataCode;
	private String name;
	private String countryIsoCode;
	
	

	public Airport() {
		super();
	}

	public Airport(String iataCode, String name, String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}
	
	

}
