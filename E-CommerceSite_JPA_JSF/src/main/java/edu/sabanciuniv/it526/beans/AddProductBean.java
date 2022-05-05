package edu.sabanciuniv.it526.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.service.CategoryService;
import edu.sabanciuniv.it526.service.ProductService;

@Named
@RequestScoped
public class AddProductBean {
	
	@Inject
	private ProductService productService;
	
	@Inject
	private CategoryService categoryService;
	
	private Product product = new Product();
	
	private Category productCategory;
	
	@PostConstruct
	public void initPage() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		this.productCategory = categoryService.getCategoryById(categoryId);
	}

	
	public String saveProduct() {
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
	

}
