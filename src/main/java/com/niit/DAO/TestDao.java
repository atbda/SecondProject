package com.niit.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Test;

@Repository
public class TestDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Test t) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
}
