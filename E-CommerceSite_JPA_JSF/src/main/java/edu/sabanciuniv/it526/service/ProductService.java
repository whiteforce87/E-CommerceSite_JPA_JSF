package edu.sabanciuniv.it526.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.sabanciuniv.it526.entity.Product;


@Stateless
public class ProductService {
	
	private int newCatId;
	private int newProductId;
	
	@PersistenceContext
	EntityManager entityManager;


	public List<Product> getAllProducts() {

		List<Product> products = entityManager.createQuery("select i from Product i", Product.class).getResultList();
		return products;
	}

	public void addProduct(Product product) {
		entityManager.persist(product);
	}

	public List<Product> getProductById(int categoryId) {

		List<Product> productsById = new ArrayList<Product>();
		
		List<Product> products = entityManager.createQuery("select i from Product i", Product.class).getResultList();
		for (Product product : products) {
			if(product.getCategory().getId() == categoryId) {
				productsById.add(product);
				
			}
		}
		if(!productsById.isEmpty()) {
		this.newCatId =productsById.get(0).getCategory().getId();
		}
		return productsById;
	}

	public void updateProductOnDatabase(Product tobeChanged) {
		System.out.println("burda database e yazdı");
		entityManager.merge(tobeChanged);

		
	}

	public int getNewCatId() {
		return newCatId;
	}
	
	

	public int getNewProductId() {
		return newProductId;
	}

	public void setNewProductId(int newProductId) {
		this.newProductId = newProductId;
	}

	public void setNewCatId(int newCatId) {
		this.newCatId = newCatId;
	}

	public Product getProductByProductId(int productId) {
			
		
		List<Product> products = entityManager.createQuery("select i from Product i", Product.class).getResultList();
		for (Product product : products) {
			if(product.getId() == productId) {
				this.newProductId = productId;
				return product;
				
			}
	}
		return null;
	}

	public void deleteProductOnDatabase(int productId) {
		
		Product toBeRemoved = entityManager.find(Product.class, productId);
		entityManager.remove(toBeRemoved);

	}
	
}
