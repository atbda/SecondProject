package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserDAOTestCase {
	static UserDAO userDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");

	}

	@Test
	public void registerUserTest() {
		User user = new User();
		user.setLoginname("ramu");
		user.setPassword("1234");
		user.setUserName("Ramesh");
		user.setEmailId("ramu@gmail.com");
		user.setAddress("Bangalore");
		user.setMobileNo("123123123");
		user.setRole("Role_ADMIN");

		assertTrue("Problem in registration", userDAO.registerUser(user));
	}
}
