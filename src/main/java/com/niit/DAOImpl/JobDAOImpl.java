package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.JobDAO;
import com.niit.model.Blog;
import com.niit.model.Job;

@Repository(value = "jobDAO")
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean publishJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;

		} catch (Exception e) {
			return false;
		}
	
	}
	@Transactional
	public boolean deleteJob(int jobId) {	
		try {
			Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, jobId);
		sessionFactory.getCurrentSession().delete(job);
		return true;
	} catch (Exception e) {
		return false;

	}
}
	
@Transactional
	public boolean updateJob(int jobId) {
		try {
			Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, jobId);
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

@Transactional
	public Job getJob(int jobId) {
	Session session=sessionFactory.openSession();
	Job job=(Job)session.get(Job.class, jobId);
	return job;
	
}
	
@Transactional
	public List<Job> listAllJobs()
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Job");
	
		List<Job> listJobs = query.getResultList();
		return listJobs;
	} 


@Transactional
public List<Job>listJobs(String username) {
	try {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Job where loginname=:username");
		query.setParameter("username", username);
		List<Job> listJobs = query.getResultList();
		return listJobs;
	} catch (Exception e) {
		e.printStackTrace();
		return null;

	}

}
@Transactional
public boolean applyJob(Job job) {
	System.out.println("--------------------job dao--------------------------------");

			try {
			
			job.setStatus("Applied");
			sessionFactory.getCurrentSession().update(job);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}

