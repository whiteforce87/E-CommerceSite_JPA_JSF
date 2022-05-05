package edu.sabanciuniv.it526.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.entity.Category;
import edu.sabanciuniv.it526.entity.Product;

@Stateless
public class CategoryService {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveCategoryToDatabase(Category newCategory) {
		entityManager.persist(newCategory);
	}

	public List<Category> getAllCategories(){
		
		List <Category> categories = entityManager.createQuery("select i from Category i",Category.class).getResultList();
		
		for (Category c : categories) {
			
			for (Product p : c.getProducts()) {
				System.out.println(p.getId());
			}
		}
		
		return categories;
	}
	
	public void deleteCategoryOnDatabase(int categoryId) {
		Category tobeRemoved = entityManager.find(Category.class, categoryId);
		for (Product a: tobeRemoved.getProducts()){
			entityManager.remove(a);
		}
		entityManager.remove(tobeRemoved);	
	}
	
	public Category getCategoryById(int categoryId) {
		return entityManager.find(Category.class, categoryId);
	}

	public void updateCategoryOnDatabase(Category tobeUpdated) {
		entityManager.merge(tobeUpdated);
		
	}

	
	
}
