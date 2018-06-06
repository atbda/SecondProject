package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {
	public boolean addBlog(Blog blog);

	public boolean deleteBlog(int blogId);

	public boolean updateBlog(Blog blog);

	public List<Blog> listBlogs(String username);

	public boolean approvalBlog(Blog blog);
	public List<Blog> listApprovedBlogs();

	public boolean rejectBlog(Blog blog);

	public Blog getBlog(int blogId);

	public List<Blog> listAllBlogs();


	public boolean incrementLike(Blog blog);
}
