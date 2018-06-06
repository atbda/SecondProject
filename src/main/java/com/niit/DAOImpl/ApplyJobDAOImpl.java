package com.niit.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ApplyJobDAO;
import com.niit.model.ApplyJob;

@Repository(value = "applyjobDAO")
public class ApplyJobDAOImpl implements ApplyJobDAO  {
	@Autowired
	SessionFactory sessionFactory;
	
	

	public boolean applyNew(ApplyJob applyJob) {

		try
		{
			sessionFactory.getCurrentSession().save(applyJob);
			
			return true;
		}
		catch(Exception ex)
		{
			
			ex.printStackTrace();
			return false;
		}
	}

	public List<ApplyJob> listByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ApplyJob> listByCompany() {
		// TODO Auto-generated method stub
		return null;
	}



}
