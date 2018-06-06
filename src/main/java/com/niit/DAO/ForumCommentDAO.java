package com.niit.DAO;

import java.util.List;


import com.niit.model.ForumComment;

public interface ForumCommentDAO {
	public boolean addForumComment(ForumComment forumComment);

	public boolean deleteForumComment(int commentId);

	public List<ForumComment> listForumComments(String username);

	public ForumComment getForumComment(int commentId);
}
