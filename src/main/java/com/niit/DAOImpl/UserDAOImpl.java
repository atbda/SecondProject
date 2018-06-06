package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
@Transactional
public boolean registerUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);

			return true;
		} catch (Exception e) {
			return false;
		}
	}
@Transactional
	public boolean checkUser(User user) {
		try
		{
			
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where userName=:userName and password=:password");
		
		System.out.println(user.getUserName()+"++++++++++++++++"+user.getPassword());
		query.setParameter("userName",user.getUserName());
		query.setParameter("password",user.getPassword());
		
		List user1=query.getResultList();
		if(user1.isEmpty())
		{
			System.out.println("false");
			return false;
			
		}
		else
		{
			System.out.println("true");

			return true;
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}




public User getUser(String userName)
{
	Session session=sessionFactory.openSession();
/*	User user=(User)session.get(User.class,loginname);
 * 
*/	
	
	
	System.out.println("from getUser()========"+userName);
	Query q=session.createQuery("from User where userName=:userName");
	q.setParameter("userName", userName);
	User user=(User)q.getSingleResult();
	return user;
	
	
}

}
