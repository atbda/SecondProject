package com.niit.DAO;

import java.util.List;

import com.niit.model.BlogComment;

public interface BlogCommentDAO {
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteBlogComment(int commentId);

	public List<BlogComment> listBlogComments(String username);

	public BlogComment getBlogComment(int commentId);

}
