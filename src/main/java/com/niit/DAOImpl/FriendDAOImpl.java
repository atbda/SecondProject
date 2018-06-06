package com.niit.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DAO.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.User;

public class FriendDAOImpl implements FriendDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Friend> showFriendList(String loginname) 
	{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Friend where (loginname=:myloginname or friendloginname=:friendlogin) and status='A'");
			query.setParameter("myloginname",loginname);
			query.setParameter("friendlogin", loginname);
			List<Friend> listFriends=(List<Friend>)query.list();
			return listFriends;	
	}

	public List<Friend> showPendingFriendRequest(String loginname) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendloginname=:myloginname and status='P'");
		query.setParameter("myloginname",loginname);
		List<Friend> listFriends=(List<Friend>)query.list();
		return listFriends;
	}

	public List<User> showSuggestedFriend(String loginname) 
	{
		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select loginname from User where loginname not in(select friendloginname from Friend where loginname='"+loginname+"') and loginname!='"+loginname+"'");
		List<String> listUsers=(List<String>)sqlQuery.list();
		ArrayList<User> listUser=new ArrayList<User>();
		int i=0;
		while(i<listUsers.size())
		{
			User user=session.get(User.class, listUsers.get(i));
			listUser.add(user);
			i++;
		}
		
		return listUser;
	}

	@Transactional
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class, friendId);
			System.out.println("Login Name"+friend.getLoginname());
			friend.setStatus("A");
			session.update(friend);
			System.out.println("Updated");
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
	}
	@Transactional
	public boolean deleteFriendRequest(int friendId) {
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class, friendId);
			session.delete(friend);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
	}

}


