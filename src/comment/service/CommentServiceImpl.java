package comment.service;

import comment.dao.CommentDAO;
import comment.dao.CommentImpl;
import member.service.JoinService;
import model.Comment;

public class CommentServiceImpl implements commentService{
	
	private CommentImpl dao;

	public CommentServiceImpl() {
		dao = new CommentImpl();
	}

	@Override
	public void writeComment(Comment c) {
		// TODO Auto-generated method stub
		
	}



}
