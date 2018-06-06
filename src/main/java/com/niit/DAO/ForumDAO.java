package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.Forum;

public interface ForumDAO {
	public boolean addForum(Forum forum);

	public boolean deleteForum(int forumId);

	public boolean updateForum(Forum forum);

	public List<Forum> listForums(String username);
	
	public List<Forum> listApprovedForums();

	public boolean approvalForum(Forum forum);

	public boolean rejectForum(Forum forum);

	public Forum getForum(int forumId);

	public List<Forum> listAllForums();

	public boolean incrementLike(Forum forum);
}
