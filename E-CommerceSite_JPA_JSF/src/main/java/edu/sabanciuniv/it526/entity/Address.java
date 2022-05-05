package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String city;
	private String street;
	private String country;
	
	@ManyToOne
	private Customer customer;

	public Address(String city, String street, String country, Customer customer) {
		super();
		this.city = city;
		this.street = street;
		this.country = country;
		this.customer = customer;
	}

	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		if(this.customer==null)
			this.customer = new Customer();
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", country=" + country + ", customer="
				+ customer + "]";
	}

}
