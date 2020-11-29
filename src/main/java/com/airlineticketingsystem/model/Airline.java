package com.airlineticketingsystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "airline")
public class Airline implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String owner ;
	
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="airline_airport",
	joinColumns= {@JoinColumn(name="airline_id",referencedColumnName = "id")},
	inverseJoinColumns= {@JoinColumn(name="airport_id",referencedColumnName = "id")})
	private Set<Airport> airports=new HashSet<Airport>();
	
	
	
	public Airline()
	{
		
	}
	
	
	public Airline(String name,String owner)
	{
		this.name=name;
		this.owner=owner;
		
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


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Set<Airport> getAirports() {
		return airports;
	}


	public void setAirports(Set<Airport> airports) {
		this.airports = airports;
	}
	
	

}
