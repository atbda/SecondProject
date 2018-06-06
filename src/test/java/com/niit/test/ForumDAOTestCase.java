package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.DAO.ForumDAO;
import com.niit.model.Blog;
import com.niit.model.Forum;

public class ForumDAOTestCase {

static ForumDAO forumDAO;
	
	@BeforeClass
	
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.niit");	
context.refresh();
forumDAO=(ForumDAO)context.getBean("forumDAO");

	}

	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setForumName("forumName");
		forum.setForumContent("Content");
		forum.setLoginname(" Rahul kumar");
		forum.setStatus("A");
		forum.setLikes(2);
		forum.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Forum Inseron",forumDAO.addForum(forum));
		
	}
	@Ignore
	@Test
	public void deleteForumTest()
	{
		assertTrue("Problem in forum Deletion:",forumDAO.deleteForum(24) );
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
		
		Forum f=forumDAO.getForum(202);
		f.setForumName("shahrukh");
		assertTrue("Problem in Forum updateing",forumDAO.updateForum(f));
		/*Forum forum=new Forum();
		forum.setForumName("Java dsfgcore");
		forum.setForumContent("Blosdgg is regarding to Java Language");
		forum.setLoginname(" Rahusgasl kumasadr");
		forum.setStatus("A");
		forum.setLikes(2);
		forum.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Forum updateing",forumDAO.updateForum(202));*/
		
	}
	@Ignore
	@Test
	public void rejectForumTest() {
		Forum forum=forumDAO.getForum(52);
		assertTrue("Problem in forum Rejection:",forumDAO.rejectForum(forum));
	}
	
	@Ignore
	@Test
	public void approvalForumTest() {
		Forum forum=forumDAO.getForum(52);
		assertTrue("Problem inblog Approval:",forumDAO.approvalForum(forum));
	}
	
	@Ignore	
	@Test
	public void listForumsByUserTest()
	{
		List<Forum>listForums=forumDAO.listForums("Rahul kumar");
		assertTrue("Problem in Listing Forums", listForums.size()>0);
		for(Forum forum:listForums)
		{
			System.out.println(forum.getForumName()+":::");
			System.out.println(forum.getForumContent()+":::");
			System.out.println(forum.getLoginname());
		}
	}
	
	@Ignore
	@Test
	public void incrementForumLikeTest() {
		Forum forum=forumDAO.getForum(152);
		assertTrue("Problem in increment of likes:",forumDAO.incrementLike(forum));
	}
	}