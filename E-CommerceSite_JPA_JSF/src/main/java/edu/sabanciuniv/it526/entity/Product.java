package edu.sabanciuniv.it526.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private double price;
	private String description;
	
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	private List<Orders> orders;
	
	@ManyToMany
	private List<Vendor> vendors;
	
	@ManyToOne
	private Campaign campaign;

	public Product() {
		super();
	}

	public Product(String name, String brand, double price, String description,Category category) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.category = category;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	public List<Orders> getOrders() {
		if(this.orders == null)
			this.orders = new ArrayList<Orders>();
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Vendor> getVendors() {
		if(this.vendors == null)
			this.vendors = new ArrayList<Vendor>();
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	

	public Campaign getCampaign() {
		if(this.campaign == null)
			this.campaign = new Campaign();
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + ", description="
				+ description + ", category=" + category + ", orders=" + orders + ", vendors=" + vendors + ", campaign="
				+ campaign + "]";
	}

}
