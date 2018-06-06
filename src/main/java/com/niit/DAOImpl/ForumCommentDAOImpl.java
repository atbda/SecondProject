package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.ForumComment;
@Repository(value = "forumCommentDAO")

public class ForumCommentDAOImpl {

	public ForumCommentDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("ForumdaoComment created....");

	}

	@Autowired
	SessionFactory sessionFactory;

@Transactional
	public boolean addForumComment(ForumComment forumComment) {
		try {
	sessionFactory.getCurrentSession().save(forumComment);
	return true;

} catch (Exception e) {
	return false;
}
	}
@Transactional
	public boolean deleteForumComment(int commentId) {
	try {
		ForumComment forumComment = (ForumComment) sessionFactory.getCurrentSession().get(ForumComment.class, commentId);
		sessionFactory.getCurrentSession().delete(forumComment);
		return true;
	} 
	catch (Exception e) 
	{
		return false;

	}
	}
@Transactional
	public List<ForumComment> listForumComments(String username) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Forum where loginname=:username");
			query.setParameter("username", username);
			List<ForumComment> listForumComments = query.getResultList();
			return listForumComments;
		} catch (Exception e) {
			return null;

		}

	}
@Transactional
	public ForumComment getForumComment(int commentId) { 
		try {
			Session session = sessionFactory.openSession();
			ForumComment forumComment = (ForumComment) session.get(ForumComment.class, commentId);
			return forumComment;
		} catch (Exception e) {
			return null;
		}
	}
	
}
