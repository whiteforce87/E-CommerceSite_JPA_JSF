package edu.sabanciuniv.it526.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.sabanciuniv.it526.entity.Customer;
import edu.sabanciuniv.it526.entity.User;

@Stateless
public class UserService {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public List<User> getAllUsers(){
		
		List <User> users = entityManager.createQuery("select i from User i",User.class).getResultList();
	
		return users;
	}
	
	public void saveUserToDatabase(User newUser) {
		entityManager.persist(newUser);
	}
	
	public Customer getUserById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}



	
	
}
