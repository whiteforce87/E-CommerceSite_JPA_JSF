package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shipping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cargoName;
	private double charge;
	
	@OneToOne
	private Orders order;
	

	public Shipping() {
		super();
	}

	
	public Shipping(String cargoName, double charge) {
		super();
		this.cargoName = cargoName;
		this.charge = charge;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCargoName() {
		return cargoName;
	}


	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}


	public double getCharge() {
		return charge;
	}


	public void setCharge(double charge) {
		this.charge = charge;
	}


	public Orders getOrder() {
		if(this.order == null)
			this.order = new Orders();
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Shipping [id=" + id + ", cargoName=" + cargoName + ", charge=" + charge + ", order=" + order + "]";
	}



}
