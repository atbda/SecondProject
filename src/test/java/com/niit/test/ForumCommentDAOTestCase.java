package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumCommentDAO;
import com.niit.model.ForumComment;

public class ForumCommentDAOTestCase {
	static ForumCommentDAO forumCommentDAO;

	@BeforeClass

	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumCommentDAO = (ForumCommentDAO) context.getBean("forumCommentDAO");

	}

	@Ignore
	@Test
	public void addForumCommentTest() {
		ForumComment forumComment = new ForumComment();
		forumComment.setCommentText("Comment");
		forumComment.setLoginname("Ravi");
		forumComment.setForumId(752);
		forumComment.setCommentDate(new java.util.Date());

		assertTrue("Problem in Forum Inseron", forumCommentDAO.addForumComment(forumComment));

	}

	@Ignore
	@Test
	public void deleteForumCommentTest() {
		assertTrue("Problem in ForumComment Deletion:", forumCommentDAO.deleteForumComment(102));
	}

	@Ignore
	@Test
	public void listForumCommentsByUserTest() {
		List<ForumComment> listForumComments = forumCommentDAO.listForumComments("Rahul kumar");
		assertTrue("Problem in Listing ForumComments", listForumComments.size() > 0);
		for (ForumComment forumComment : listForumComments) {
			System.out.println(forumComment.getLoginname() + ":::");
			System.out.println(forumComment.getCommentText() + ":::");
			System.out.println(forumComment.getForumId());
		}
	}

}
