package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobDAO;

import com.niit.model.Job;



public class JobDAOTestCase {

static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
context.scan("com.niit");	
context.refresh();
jobDAO=(JobDAO)context.getBean("jobDAO");

	}
	
	@Test
	public void publishJobTest()
	{
		Job job=new Job();
		job.setCompany("Company");
		job.setJobDesignation("cgcgcgcgcgcgcgcgcgc");
		job.setJobDescription("Spring Developer");
		job.setSalary(20000);
		job.setLocation("Bangalore");
		job.setCreatedDate(new Date());
		
		assertTrue("Problem in job Inseron",jobDAO.publishJob(job));
		
		}
	
	@Ignore
	@Test
	public void deleteJobTest()
	{
		assertTrue("Problem in Job Deletion:",jobDAO.deleteJob(702));
	}
	
	
	
	@Ignore	
	@Test
	public void listJobsTest()
	{
		List<Job>listJobs=jobDAO.listAllJobs();
		assertNotNull("problem in listing jobs",listJobs);
		for(Job job:listJobs)
		{
			System.out.println(job.getCompany()+":::");
			System.out.println(job.getLocation());
		}
	}
	
	@Ignore
	@Test
	public void updateJobTest()
	{
		Job job=jobDAO.getJob(123);
		job.setCompany("ajshk");
		job.setJobDesignation("gkjdsahgku");
		
		
		assertTrue("Problem in updation",jobDAO.updateJob(123));
	}
}
