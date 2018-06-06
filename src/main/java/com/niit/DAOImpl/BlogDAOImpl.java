package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;

@Repository(value = "blogDAO")
public class BlogDAOImpl implements BlogDAO {

	public BlogDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Blogdao created....");

	}

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * public boolean addBlog(Blog blog) { try { Session
	 * session=sessionFactory.openSession(); session.beginTransaction();
	 * session.save(blog); session.getTransaction().commit();
	 * System.out.println("hhhhhhhhhhhhhhhhhhhhh"); return true; } catch(Exception
	 * e) { e.printStackTrace(); return false; } }
	 */
	@Transactional
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(int blogId) {
		try {
			Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} 
		catch (Exception e) 
		{
			return false;

		}
	}

	@Transactional
	public boolean updateBlog(Blog blog) {
		try {
			
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	@Transactional
	public List<Blog>listBlogs(String username) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Blog where loginname=:username");
			query.setParameter("username", username);
			List<Blog> listBlogs = query.getResultList();
			return listBlogs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	@Transactional
	public boolean approvalBlog(Blog blog) {

		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean rejectBlog(Blog blog) {

		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public Blog getBlog(int blogId) {
		try {
			Session session = sessionFactory.openSession();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			return blog;
		} catch (Exception e) {
			return null;
		}
	}
	
	/*  @Transactional 
	  public List<Blog> listAllBlogs()
	  {
		  try
		  {
			  Session session =	  sessionFactory.openSession(); 
			  Query query = session.createQuery("from Blog");
	  List<Blog> listBlogs =query.list();
	  return listBlogs;
	  
	  }
		  catch (Exception e) 
		  {
			  return null;
	  
	  }
	  
	  }*/
	 

	@Transactional
	public List<Blog>listAllBlogs() {
		try {
			Session session = sessionFactory.openSession();
			return session.createQuery("from Blog").getResultList();

		} catch (Exception e) {
			return null;

		}

	}

	public boolean incrementLike(Blog blog) {
		try
		{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
	
		}
}

	public List<Blog>listApprovedBlogs() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Blog where status='A'");
			//query.setParameter("status", status);
			List<Blog> listBlogs = query.getResultList();
			return listBlogs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}}

