package com.niit.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.ForumDAO;
import com.niit.DAO.FriendDAO;
import com.niit.DAO.JobDAO;
import com.niit.DAO.ProfilePictureDAO;
import com.niit.DAO.UserDAO;
import com.niit.DAOImpl.BlogDAOImpl;
import com.niit.DAOImpl.ForumDAOImpl;
import com.niit.DAOImpl.FriendDAOImpl;
import com.niit.DAOImpl.JobDAOImpl;
import com.niit.DAOImpl.ProfilePictureDAOImpl;
import com.niit.DAOImpl.UserDAOImpl;
import com.niit.model.ApplyJob;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.ProfilePicture;
import com.niit.model.User;

@Configuration
@ComponentScan(basePackages= {"com.niit"})
@EnableTransactionManagement
public class DBConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("basha");
		dataSource.setPassword("basha");
		return dataSource;
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProp.put("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);

		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		sessionFactoryBuilder.addAnnotatedClass(ApplyJob.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addAnnotatedClass(Friend.class);


		SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
		System.out.println("-----------SessionFactory Object------");

		return sessionFactory;
	}

	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
		return new BlogDAOImpl();
	}
	
	
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO()
	{
		return new ForumDAOImpl();
	}

	@Bean(name="jobDAO")
	public JobDAO getJobDAO()
	{
		return new JobDAOImpl();
	}
	

	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		return new UserDAOImpl();
	}

	@Bean(name="profilePictureDAO")
	public ProfilePictureDAO getProfilePictureDAO()
	{
		return new ProfilePictureDAOImpl();
	}
	
	
	@Bean(name="friendDAO")
	public FriendDAO getFriendDAO()
	{
		return new FriendDAOImpl();
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(getSessionFactory());

		System.out.println("---------Hibernate Object--------");
		return hibernateTransactionManager;

	}

}Scanner input= new Scanner (System.in);
private int choice;
UserDAO udao=new UserDaoImpl();
public void loginMenu()
{
	System.out.println("Welcome To our World, Please Login or Register first");
	System.out.println("1.Login");
	System.out.println("2.Registration");
	System.err.print("Please enter your choice: ");
	choice=input.nextInt();
	
	}

public void showMenu()

{
	while(true) {
		loginMenu();
		switch(choice) {
		case 1:
			System.out.println("Login");
			break;
		
		case 2:
		//System.out.println("Registration");	
			onRegistration();
			pressAnyKeyToContinue();
		break;
		
		default:System.out.println("Invalide");
		break;
		
		
	
		}
		
	}
	
}

private void pressAnyKeyToContinue() {
	// TODO Auto-generated method stub
	System.out.println("press any key to continue.....");
	try {
		System.in.read();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void onRegistration() {
	
	System.out.println("Registration");
	
	
	System.out.print("Enter NAME: ");
	String name=input.next();
	
	System.out.print("Enter USERNAME: ");
	String username=input.next();
	
	System.out.print("Enter PASSWROD: ");
	String password=input.next();
	
	System.out.print("Enter EMAIL: ");
	String email=input.next();
	
	System.out.print("Enter mobileNo: ");
	String mobileNo=input.next();
	
	System.out.print("Enter ADDRESS: ");
	String address=input.next();
	
	
	User u=new User();
	u.setName(name);
	u.setUserName(username);
	u.setPassword(password);
	u.setMobileNo(mobileNo);
	u.setEmailId(email);
	u.setAddress(address);
	
	
	udao.save(u);
	
	System.out.println("SUCCESS....");
	
	
	// TODO Auto-generated method stub
	
