package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.RowEditEvent;
import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.service.CategoryService;
import edu.sabanciuniv.it526.service.ProductService;



@Named
@RequestScoped
public class ProductListBean {
	

	Product product = new Product();
	
	List<Product> products;
	private Category productCategory;
	
	@Inject
	ProductService productService;
	@Inject
	private CategoryService categoryService;
	
	
	@PostConstruct
	public void initPage() {
		int categoryId;
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		if(req.getParameter("categoryId") == null) {
			categoryId = productService.getNewCatId();
			System.out.println(categoryId);
		}else {
			categoryId = Integer.parseInt(req.getParameter("categoryId"));
			System.out.println(categoryId);
		}
		this.products = productService.getProductById(categoryId);
		this.productCategory = categoryService.getCategoryById(categoryId);
	
	}
	

	public String deleteProduct(int productId){
		
		productService.deleteProductOnDatabase(productId);
		return "list_products_of_category.xhtml?faces-redirect=true";
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public void updateProduct(RowEditEvent evt) {
		Product tobeChanged = (Product)evt.getObject();
		productService.updateProductOnDatabase(tobeChanged);
	}

	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Category getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
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
	
	
	
	
	

}
