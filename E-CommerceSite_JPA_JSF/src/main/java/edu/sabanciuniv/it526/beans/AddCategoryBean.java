package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.service.CategoryService;

@Named
@RequestScoped
public class AddCategoryBean {
	
	
	@Inject
	private CategoryService categoryService;
	
	private List<Category> categories;
	
	private Category category= new Category();
	
	private Product product = new Product();
	
	private Category productCategory;
	
	@PostConstruct
	public void initPage() {
		
		this.categories = categoryService.getAllCategories();
	}

	
	public String saveCategory() {
	
		categoryService.saveCategoryToDatabase(this.category);
		this.categories = categoryService.getAllCategories();
		this.category = new Category();
		return "categoryList?faces-redirect=true";
		
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


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	

}
