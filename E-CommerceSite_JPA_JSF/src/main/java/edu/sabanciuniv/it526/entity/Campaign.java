package edu.sabanciuniv.it526.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private String code;
	private String name;
	private String description;
	
	
	@OneToMany(mappedBy = "campaign")
	private List<Product> products;
	
	
	public Campaign() {
		super();
	}


	public Campaign(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Product> getProducts() {
		if(this.products==null)
			this.products= new ArrayList<Product>();
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Campaign [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", products=" + products + "]";
	}


}
