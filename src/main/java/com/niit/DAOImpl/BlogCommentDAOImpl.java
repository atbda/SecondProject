package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.BlogCommentDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;

@Repository(value = "blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO
{
	public BlogCommentDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("BlogdaoComment created....");

	}

	@Autowired
	SessionFactory sessionFactory;

@Transactional
	public boolean addBlogComment(BlogComment blogComment) {
		try {
	sessionFactory.getCurrentSession().save(blogComment);
	return true;

} catch (Exception e) {
	return false;
}
	}
@Transactional
	public boolean deleteBlogComment(int commentId) {
	try {
		BlogComment blogComment = (BlogComment) sessionFactory.getCurrentSession().get(BlogComment.class, commentId);
		sessionFactory.getCurrentSession().delete(blogComment);
		return true;
	} 
	catch (Exception e) 
	{
		return false;

	}
	}
@Transactional
	public List<BlogComment> listBlogComments(String username) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Blog where loginname=:username");
			query.setParameter("username", username);
			List<BlogComment> listBlogComments = query.getResultList();
			return listBlogComments;
		} catch (Exception e) {
			return null;

		}

	}
@Transactional
	public BlogComment getBlogComment(int commentId) { 
		try {
			Session session = sessionFactory.openSession();
			BlogComment blogComment = (BlogComment) session.get(BlogComment.class, commentId);
			return blogComment;
		} catch (Exception e) {
			return null;
		}
	}
	

}
