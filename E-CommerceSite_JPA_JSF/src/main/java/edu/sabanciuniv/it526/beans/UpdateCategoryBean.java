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
public class UpdateCategoryBean {
	
	
	@Inject
	private CategoryService categoryService;
	
	private List<Category> categories;
	
	private Category category= new Category();
	private String catName;
	private int catId;
	
	@PostConstruct
	public void initPage() {
		
		this.categories = categoryService.getAllCategories();
	}

	
	public String updateCategory() {
	
		this.category =categoryService.getCategoryById(catId);
		this.category.setName(catName);
		categoryService.updateCategoryOnDatabase(this.category);
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


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}

}
