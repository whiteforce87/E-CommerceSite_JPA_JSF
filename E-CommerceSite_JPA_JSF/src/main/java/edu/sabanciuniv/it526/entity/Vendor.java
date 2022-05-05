package edu.sabanciuniv.it526.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	
	
	@ManyToMany(mappedBy = "vendors")
	private List<Product> products;
	
	
	public Vendor() {
		super();
	}

	
	public Vendor(String name, String address, String phoneNumber, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Product> getProducts() {
		if(this.products == null)
			this.products = new ArrayList<Product>();
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", products=" + products + "]";
	}
	

	


}
