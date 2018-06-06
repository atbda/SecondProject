package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;

import oracle.net.aso.p;

public class BlogDAOTestCase {
	static BlogDAO blogDAO;
	
	@BeforeClass
	
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.niit");	
context.refresh();
blogDAO=(BlogDAO)context.getBean("blogDAO");

	}
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Java core");
		blog.setBlogContent("Blog is regarding to Java Language");
		blog.setLoginname(" Rahul kumar");
		blog.setStatus("A");
		blog.setLikes(2);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Blog Inseron",blogDAO.addBlog(blog));
		
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		assertTrue("Problem in Blog Deletion:",blogDAO.deleteBlog(102) );
	}
	
	@Test
	public void updateBlogTest()
	{
		Blog b=blogDAO.getBlog(202);
		b.setBlogName("shahrukh");
		assertTrue("Problem in Blog updateing",blogDAO.updateBlog(b));
		
	}
	@Ignore
	@Test
	public void rejectBlogTest() {
		Blog blog=blogDAO.getBlog(52);
		assertTrue("Problem in blog Rejection:",blogDAO.rejectBlog(blog));
	}
	
	@Ignore
	@Test
	public void approvalBlogTest() {
		Blog blog=blogDAO.getBlog(52);
		assertTrue("Problem inblog Approval:",blogDAO.approvalBlog(blog));
	}
	@Ignore	
	@Test
	public void listBlogsByUserTest()
	{
		List<Blog>listBlogs=blogDAO.listBlogs("Rahul kumar");
		assertTrue("Problem in Listing Blogs", listBlogs.size()>0);
		for(Blog blog:listBlogs)
		{
			System.out.println(blog.getBlogName()+":::");
			System.out.println(blog.getBlogContent()+":::");
			System.out.println(blog.getLoginname());
		}
	}
	
	@Ignore
	@Test
	public void incrementBlogLikeTest() {
		Blog blog=blogDAO.getBlog(152);
		assertTrue("Problem in increment of likes:",blogDAO.incrementLike(blog));
	}
	
	
	
	
	
	
	
	
	}


