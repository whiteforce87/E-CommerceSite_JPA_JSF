package edu.sabanciuniv.it526.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.sabanciuniv.it526.entity.User;
import edu.sabanciuniv.it526.service.UserService;


@Named
@SessionScoped
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private boolean loggedIn = false;
	
	private User user = new User();
	
	private List<User> users;
	
	@Inject
	private UserService userService;
	
	
	public String logIn() {
		
		if(userName.equals(userService.getAllUsers().get(0).getUserName()) 
				&& password.equals(userService.getAllUsers().get(0).getPassword())) {
			this.loggedIn = true;
			System.out.println("User loggedIn");
			return "categoryList?faces-redirect=true";
		}else {
			System.out.println("Wrong UserName or Password");
			FacesMessage msg = new FacesMessage("Username or Password is Wrong!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
		return null;
	}
	
	public String logOut() {
		
		this.loggedIn = false;
		this.userName = null;
		this.password = null;
		System.out.println("User loggedOut");
		return "categoryList?faces-redirect=true";
		
	}
	
	@PostConstruct
	public void initPage() {
		if(userService.getAllUsers().isEmpty()) {
			createUser();
			}
		this.users = userService.getAllUsers();
		
	}
	
	
	public void createUser() {
		User admin = new User("admin", "123456");
		userService.saveUserToDatabase(admin);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
