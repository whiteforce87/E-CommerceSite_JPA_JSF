package edu.sabanciuniv.it526.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;
import edu.sabanciuniv.it526.service.CategoryService;
import edu.sabanciuniv.it526.service.ProductService;

@Named
@RequestScoped
public class CategoryBean {
	
	private Category category= new Category();
	
	private List<Category> categories;
	
	@Inject
	private CategoryService categoryService;
	
	@Inject
	private ProductService productService;
	
	@PostConstruct
	public void initPage() {
		if(categoryService.getAllCategories().isEmpty()) {
		existedCaturgories();
		}
		this.categories = categoryService.getAllCategories();
		
	}


	public String deleteCategory(int categoryId)
	{
		categoryService.deleteCategoryOnDatabase(categoryId);
		return "categoryList.xhtml?faces-redirect=true";
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
	
	
	public void saveCategory() {
		categoryService.saveCategoryToDatabase(this.category);
		this.categories = categoryService.getAllCategories();
		this.category = new Category();
	}
	
	public void updateCategory(RowEditEvent evt) {
		Category tobeUpdated = (Category)evt.getObject();
		categoryService.updateCategoryOnDatabase(tobeUpdated);
		
	}
	 
	public void existedCaturgories() {
		Category electronic = new Category("Electronic");
		categoryService.saveCategoryToDatabase(electronic);
		Product mackbook = new Product("MackBook","Apple" , 2000, "13' Mackbook Pro" ,electronic);
		productService.addProduct(mackbook);
		Product iphone = new Product("Iphone","Apple" , 600, "Iphone11 Black",electronic);
		productService.addProduct(iphone);
		Product tv = new Product("Tv","Samsung" , 800, "77' LED",electronic);
		productService.addProduct(tv);
		Product playStation = new Product("PlayStation","Sony" ,800, "Playstation4 Black",electronic);
		productService.addProduct(playStation);
		
		
		Category moda = new Category("Moda");
		categoryService.saveCategoryToDatabase(moda);
		Product shoe = new Product("Shoe", "Adidas", 40, "44cm White",moda);
		productService.addProduct(shoe);
		Product pants = new Product("Pants", "Levis", 50, "33-34 size 501",moda);
		productService.addProduct(pants);
		Product shirt = new Product("Shirt", "Zara", 30, "Mixed Color Larrge",moda);
		productService.addProduct(shirt);
		Product coat = new Product("Coat", "Colombia", 100, "XL Blue Shield",moda);
		productService.addProduct(coat);
		
		
		Category home = new Category("Home");
		categoryService.saveCategoryToDatabase(home);
		Product showcase = new Product("Showcase", "Ikea", 100, "Brown Wood 150cmx200cm",home);
		productService.addProduct(showcase);
		Product  diningTable = new Product("Dining Table", "Vinense", 150, "White 60cmx200cm",home);
		productService.addProduct(diningTable);
		Product bed = new Product("Bed", "Kelebek", 100, "Twin 100cmx200cm",home);
		productService.addProduct(bed);
		Product sofa = new Product("Sofa", "Mondi", 200, "Yellow 30cmx50cmx180cm",home);
		productService.addProduct(sofa);
		
		
		Category sport = new Category("Sport");
		categoryService.saveCategoryToDatabase(sport);
		Product basketballShoe = new Product("BasketballShoe", "Nike", 50, "43cm red",sport);
		productService.addProduct(basketballShoe);
		Product shorts = new Product("Shorts", "Kappa", 20, "Medium Size Green",sport);
		productService.addProduct(shorts);
		Product tshirt = new Product("Tshirt", "UnderArmor", 50, "Small Size Dark Blue",sport);
		productService.addProduct(tshirt);
		Product dumble = new Product("Dumble", "Reebok", 35, "20kg Black",sport);
		productService.addProduct(dumble);
		
		
		Category toy = new Category("Toy");
		categoryService.saveCategoryToDatabase(toy);
		Product batman = new Product("Batman", "DC", 20, "Batman Forever Series",toy);
		productService.addProduct(batman);
		Product superman = new Product("Superman", "DC", 25, "Superman Criptonium Series",toy);
		productService.addProduct(superman);
		Product aquaman = new Product("Aquaman", "DC", 15, "Aquaman II Series",toy);
		productService.addProduct(aquaman);
		Product carToy = new Product("Car", "Ferrari", 10, "Fast Cars Concept",toy);
		productService.addProduct(carToy);
		Product barbie = new Product("Barbie", "Disney", 10, "Barbie and Fony",toy);
		productService.addProduct(barbie);
		
		
		Category music = new Category("Music");
		categoryService.saveCategoryToDatabase(music);
		Product gramophone = new Product("Gramophone", "Lenco", 150, "220 Volt, 45' Size ",music);
		productService.addProduct(gramophone);
		Product guitar = new Product("Guitar", "Gibson", 2000, "LesPaul Custom 1978",music);
		productService.addProduct(guitar);
		Product amplifier = new Product("Amplifier", "Marshall", 1000, "500 Watt 2 input/output",music);
		productService.addProduct(amplifier);
		Product headset = new Product("Headset", "JBL", 40, "20 Watt Black",music);
		productService.addProduct(headset);
		
		
		Category car = new Category("Car Accessory");
		categoryService.saveCategoryToDatabase(car);
		Product tier = new Product("Tier", "Lassa", 60, "18' Winter",car);
		productService.addProduct(tier);
		Product wiper = new Product("Wiper", "Bmw", 20, "30cm Black",car);
		productService.addProduct(wiper);
		Product rim = new Product("Rim", "Mercedes", 500, "18' Aluminium",car);
		productService.addProduct(rim);
		Product stopLamp = new Product("Stop Lamp", "Audi", 100, "Led Red Wide",car);
		productService.addProduct(stopLamp);
		
		
		Category cosmetics = new Category("Cosmetics");
		categoryService.saveCategoryToDatabase(cosmetics);
		Product shampoo = new Product("Shampoo", "Blendax", 5, "3 in 1",cosmetics);
		productService.addProduct(shampoo);
		Product parfume = new Product("Parfume", "Hugo Boss", 50, "Soft and Fresh",cosmetics);
		productService.addProduct(parfume);
		Product deodorant = new Product("Deodorant", "Rexona", 3, "7/24",cosmetics);
		productService.addProduct(deodorant);
		Product moisturizer = new Product("Moisturizer Cream", "Nivea", 2, "Hand and Body",cosmetics);
		productService.addProduct(moisturizer);
		
		
	}

}
