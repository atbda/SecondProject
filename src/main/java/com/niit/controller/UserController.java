package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HttpSessionMutexListener;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.Blog;
import com.niit.model.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;

	/*
	 * @GetMapping("/getAllUsers") public ResponseEntity<List<User>> getAllUsers() {
	 * List<User> users = userDAO.getAllUser();
	 * 
	 * return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	 * 
	 * }
	 */

	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		// blog.setStatus("NA");
		// blog.setLikes(0);
		// blog.setLoginname("Ravi Kumar");
		// blog.setUsername(session.getAttribute("username").toString());
		// String date = dt.getDateTime();

		// boolean value = blogDAO.addBlog(blog);

		// System.out.println("user Full Name:"+user.getFullName());
		// System.out.println("user Name:"+user.getUsername());

		if (userDAO.registerUser(user)) {

			return new ResponseEntity<String>("User Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping(value = "/checklogin")
	public ResponseEntity<User> checklogin(@RequestBody User user, HttpSession session) {

		if (userDAO.checkUser(user))

		{
			User tempUser = userDAO.getUser(user.getLoginname());
			session.setAttribute("user", tempUser);
			return new ResponseEntity<User>(tempUser, HttpStatus.OK);

		} else {
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}
	}

	/*
	 * @GetMapping("/getById/{userId}") public
	 * ResponseEntity<String>approveUser(@PathVariable("userId")int userId) { User
	 * user=(User)userDAO.getById(userId); if(userDAO.saveUser(user)) { return new
	 * ResponseEntity<String>("Approved",HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
	 * 
	 * 
	 * } } /*
	 * 
	 * @GetMapping("/rejectBlog/{blogId}") public
	 * ResponseEntity<String>rejectBlog(@PathVariable("blogId")int blogId) { Blog
	 * blog=(Blog)blogDAO.getBlog(blogId); if(blogDAO.rejectBlog(blog)) { return new
	 * ResponseEntity<String>("rejected",HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
	 * 
	 * 
	 * } }
	 * 
	 * @GetMapping("/deleteBlog/{blogId}") public
	 * ResponseEntity<String>deleteBlog(@PathVariable("blogId")int blogId) {
	 * 
	 * if(blogDAO.deleteBlog(blogId)) { return new
	 * ResponseEntity<String>("deleted",HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
	 * 
	 * 
	 * } }
	 * 
	 * @GetMapping("/incrementLike/{blogId}") public
	 * ResponseEntity<String>incrementBlog(@PathVariable("blogId")int blogId) { Blog
	 * blog=(Blog)blogDAO.getBlog(blogId); if(blogDAO.incrementLike(blog)) { return
	 * new ResponseEntity<String>("incremented",HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("Error",HttpStatus.OK);
	 * 
	 * } }
	 * 
	 * @GetMapping("/getBlog/{blogId}") public
	 * ResponseEntity<String>getBlog(@PathVariable("blogId")int blogId) { Blog
	 * blog=(Blog)blogDAO.getBlog(blogId); if(blog!=null) { return new
	 * ResponseEntity<String>("Get a Blog",HttpStatus.OK); } else { return new
	 * ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
	 * 
	 * } }
	 */

}
