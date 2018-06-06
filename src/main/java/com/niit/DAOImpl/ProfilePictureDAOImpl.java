package com.niit.DAOImpl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.ProfilePictureDAO;
import com.niit.model.ProfilePicture;


@Repository(value="profilePictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	@Autowired
	SessionFactory sessionFactory;
	//@Transactional
	public void save(ProfilePicture profilePicture) 
	{
		
		
		System.out.println(profilePicture.getLoginname()+"--------------------------------"+profilePicture.getImage());
		try {
			Session session=sessionFactory.openSession();
session.beginTransaction();
			session.save(profilePicture);
session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Transactional
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}
}
