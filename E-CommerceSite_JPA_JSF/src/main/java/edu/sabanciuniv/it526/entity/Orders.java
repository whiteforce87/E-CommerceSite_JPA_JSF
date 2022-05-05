package edu.sabanciuniv.it526.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@ManyToOne
	private Customer customer;
	
	@ManyToMany(mappedBy = "orders")
	private List<Product> products;
	
	@OneToOne
	private Payment payment;

	@OneToOne
	private Shipping shipping;
	
	public Orders() {
		super();
	}
	

	public Orders(Customer customer, List<Product> products) {
		super();
		this.customer = customer;
		this.products = products;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer getCustomer() {
		if(this.customer == null)
			this.customer = new Customer();
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		if(this.products == null)
			this.products = new ArrayList<Product>();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Payment getPayment() {
		if(this.payment == null)
			this.payment = new Payment();
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	

	public Shipping getShipping() {
		return shipping;
	}


	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}


	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", products=" + products + ", payment=" + payment
				+ ", shipping=" + shipping + "]";
	}


}
