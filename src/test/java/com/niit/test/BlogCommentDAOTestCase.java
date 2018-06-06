package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogCommentDAO;
import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

public class BlogCommentDAOTestCase {

static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.niit");	
context.refresh();
blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");

	}
	@Ignore
	@Test
	public void addBlogCommentTest()
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setCommentText("Comment");
		blogComment.setLoginname("Ravi");
		blogComment.setBlogId(752);
		blogComment.setCommentDate(new java.util.Date());

		
		assertTrue("Problem in Blog Inseron",blogCommentDAO.addBlogComment(blogComment));
		
	}
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		assertTrue("Problem in BlogComment Deletion:",blogCommentDAO.deleteBlogComment(102) );
	}
	

	@Ignore	
	@Test
	public void listBlogCommentsByUserTest()
	{
		List<BlogComment>listBlogComments=blogCommentDAO.listBlogComments("Rahul kumar");
		assertTrue("Problem in Listing BlogComments", listBlogComments.size()>0);
		for(BlogComment blogComment:listBlogComments)
		{
			System.out.println(blogComment.getLoginname()+":::");
			System.out.println(blogComment.getCommentText()+":::");
			System.out.println(blogComment.getBlogId());
		}
	}
	
}
