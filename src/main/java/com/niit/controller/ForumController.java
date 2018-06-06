package com.niit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.niit.DAO.ForumDAO;

import com.niit.model.Forum;


@RestController
public class ForumController {
	@Autowired
	ForumDAO forumDAO;

	
	@GetMapping("/getAllForums")
	public ResponseEntity<List<Forum>> getAllForums() {
		List<Forum> forums = forumDAO.listAllForums();

		return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);

	}

	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum) {

		//blog.setStatus("NA");
		//blog.setLikes(0);
		//blog.setLoginname("Ravi Kumar");
		// blog.setUsername(session.getAttribute("username").toString());
		// String date = dt.getDateTime();
		forum.setCreateDate(new Date());
		// boolean value = blogDAO.addBlog(blog);
		
		System.out.println("Forum Name:"+forum.getForumName());
		System.out.println("Forum Content:"+forum.getForumContent());
		
		if (forumDAO.addForum(forum)) 
		{

			return new ResponseEntity<String>("Forum Added", HttpStatus.OK);
		} 
		else
		{
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
@GetMapping("/approveForum/{forumId}")
public ResponseEntity<String>approveForum(@PathVariable("forumId")int forumId)
{
	Forum forum=(Forum)forumDAO.getForum(forumId);
	if(forumDAO.approvalForum(forum))
	{
		return new ResponseEntity<String>("Approved",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
		
		
	}
}

@GetMapping("/rejectForum/{forumId}")
public ResponseEntity<String>rejectForum(@PathVariable("forumId")int forumId)
{
	Forum forum=(Forum)forumDAO.getForum(forumId);
	if(forumDAO.rejectForum(forum))
	{
		return new ResponseEntity<String>("rejected",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
		
		
	}
}
@GetMapping("/deleteForum/{forumId}")
public ResponseEntity<String>deleteForum(@PathVariable("forumId")int forumId)
{
	
	if(forumDAO.deleteForum(forumId))
	{
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
		
		
	}
}

@GetMapping("/incrementLike/{forumId}")
public ResponseEntity<String>incrementForum(@PathVariable("forumId")int forumId)
{
	Forum forum=(Forum)forumDAO.getForum(forumId);
	if(forumDAO.incrementLike(forum))
	{
		return new ResponseEntity<String>("incremented",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error",HttpStatus.OK);
				
	}
}

@GetMapping("/getForum/{forumId}")
public ResponseEntity<String>getForum(@PathVariable("forumId")int forumId)
{
	Forum forum=(Forum)forumDAO.getForum(forumId);
	if(forum!=null)
	{
		return new ResponseEntity<String>("Get a Forum",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
				
	}
}


}


