package edu.sabanciuniv.it526.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	
	
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;

	public Customer() {
		super();
	}

	public Customer(String name, String lastName, String email, String phoneNumber, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Orders> getOrders() {
		if(this.orders==null)
			this.orders = new ArrayList<Orders>();
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	

	public List<Address> getAddresses() {
		if(this.addresses==null)
			this.addresses = new ArrayList<Address>();
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", orders="
				+ orders + "]";
	}

	
	
	

}
