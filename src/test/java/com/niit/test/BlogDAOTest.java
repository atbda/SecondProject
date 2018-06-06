package com.niit.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.TestDao;
import com.niit.DBConfig.DBConfig;
import com.niit.model.Blog;
import com.niit.model.Test;

public class BlogDAOTest {

	public static void main(String[] args) {
		ApplicationContext c=new AnnotationConfigApplicationContext(DBConfig.class);
		BlogDAO	blogDAO=(BlogDAO)c.getBean("blogDAO");
		Blog blog=new Blog();
		blog.setBlogId(1);
		blog.setBlogName("Java");
		blog.setBlogContent("Blog is regarding to Java Language");
		blog.setLoginname("ravi");
		blog.setStatus("A");
		blog.setLikes(1);
		blog.setCreateDate(new  Date());
		blogDAO.addBlog(blog);
		//TestDao dao=c.getBean(TestDao.class);
	/*	
		Test t=new Test();
		t.setId(22);
		t.setName("tst kr rhe");
		dao.save(t);*/
		
		System.out.println("done.........................");
	}

}
