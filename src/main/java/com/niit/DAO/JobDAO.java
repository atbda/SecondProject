package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.Job;

public interface JobDAO {
	
	public boolean publishJob(Job job);

	public boolean deleteJob(int jobId);

	public boolean updateJob(int jobId);

	public boolean applyJob(Job job);
	
	public List<Job> listAllJobs();
	
	public List<Job> listJobs(String username);
	public Job getJob(int jobId);
	



}
