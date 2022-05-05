package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long cardNumber;
	private String customerName;
	private String customerLastName;
	private String expireDate;
	private int cvcNumber;
	
	@OneToOne
	private Orders order;
	

	public Payment() {
		super();
	}

	
	public Payment(long cardNumber, String customerName, String customerLastName, String expireDate, int cvcNumber) {
		super();
		this.cardNumber = cardNumber;
		this.customerName = customerName;
		this.customerLastName = customerLastName;
		this.expireDate = expireDate;
		this.cvcNumber = cvcNumber;
	}





	public long getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}


	public String getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public int getCvcNumber() {
		return cvcNumber;
	}


	public void setCvcNumber(int cvcNumber) {
		this.cvcNumber = cvcNumber;
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
		return "Payment [id=" + id + ", cardNumber=" + cardNumber + ", customerName=" + customerName
				+ ", customerLastName=" + customerLastName + ", expireDate=" + expireDate + ", cvcNumber=" + cvcNumber
				+ ", order=" + order + "]";
	}
	
	


}
