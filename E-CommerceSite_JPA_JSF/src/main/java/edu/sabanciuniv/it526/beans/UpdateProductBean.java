package edu.sabanciuniv.it526.beans;

import java.util.List;
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
public class UpdateProductBean {

	@Inject
	private CategoryService categoryService;
	
	@Inject
	private ProductService productService;
	
	private List<Category> categories;
	
	private Category category= new Category();

	private Category productCategory;
	private Product product = new Product();

	private List<Product> products;
	
	@PostConstruct
	public void initPage() {
		int productId;
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if(req.getParameter("productId") == null) {
			productId = productService.getNewProductId();
			System.out.println("--------------productId");
		}else {
			productId = Integer.parseInt(req.getParameter("productId"));	
		}
		this.product = productService.getProductByProductId(productId);
		this.productCategory = this.product.getCategory();
	
	}
	
	public String updateProduct() {
		
		this.product.setCategory(productCategory);
		productService.updateProductOnDatabase(this.product);
		return "list_products_of_category.xhtml?faces-redirect=true";
		
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



	public Category getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
