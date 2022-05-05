package edu.sabanciuniv.it526.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.service.CategoryService;
import edu.sabanciuniv.it526.service.ProductService;
import java.io.Serializable;

@Named
@RequestScoped
public class AddProductBean2 {
	

	@Inject
	private ProductService productService;
	
	@Inject
	private CategoryService categoryService;
	
	private Product product = new Product();
	private List<Product> products;
	private List<Category> categories;
	private int catId;
	
	private Category productCategory;
	
	@PostConstruct
	public void initPage() {
		this.categories = categoryService.getAllCategories();
		
	}

	public String saveProduct() {
		this.productCategory = categoryService.getCategoryById(this.catId);
		this.product.setCategory(productCategory);
		productService.addProduct(this.product);
		return "categoryList?faces-redirect=true";
	}
	
	
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}


}
