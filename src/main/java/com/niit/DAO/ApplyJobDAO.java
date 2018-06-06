package com.niit.DAO;


import java.util.List;

import com.niit.model.ApplyJob;

public interface ApplyJobDAO {

public boolean applyNew(ApplyJob applyJob);
	
	public List<ApplyJob> listByUser(String username);
	
	public List<ApplyJob> listByCompany();

}
