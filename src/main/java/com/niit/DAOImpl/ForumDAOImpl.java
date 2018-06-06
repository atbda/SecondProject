package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ForumDAO;
import com.niit.model.Blog;
import com.niit.model.Forum;

@Repository(value = "forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addForum(Forum forum) {

		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteForum(int forumId) {
		try {
			Forum forum = (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	@Transactional
	public boolean updateForum(Forum forum) {
try {
			
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	@Transactional
	public List<Forum> listForums(String username) {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Forum where loginname=:username");
			query.setParameter("username", username);
			List<Forum> listForums = query.getResultList();
			return listForums;
		} catch (Exception e) {
			return null;

		}
	}

	@Transactional
	public boolean approvalForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Forum getForum(int forumId) {
		try {
			Session session = sessionFactory.openSession();
			Forum forum = (Forum) session.get(Forum.class, forumId);
			return forum;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public List<Forum> listAllForums() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Forum");
			List<Forum> listForums = query.getResultList();
			return listForums;

		} catch (Exception e) {
			return null;

		}
	}

	@Transactional
	public boolean incrementLike(Forum forum) {
		try {
			int likes = forum.getLikes();
			likes++;
			forum.setLikes(likes);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	

	public List<Forum> listApprovedForums() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Forum where status='A'");
			//query.setParameter("status", status);
			List<Forum> listForums = query.getResultList();
			return listForums;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
}