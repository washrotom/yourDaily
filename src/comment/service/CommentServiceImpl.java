package comment.service;



import java.util.ArrayList;
import java.util.List;

import comment.dao.CommentDAO;
import comment.dao.CommentImpl;
import model.Comment;

public  class CommentServiceImpl implements CommentService{
	
	private CommentDAO dao;
	
	public CommentServiceImpl() {
		dao = new CommentImpl();
	}

	@Override
	public void writeComment(Comment c) {
		// TODO Auto-generated method stub
		dao.insert(c);
	}

	@Override
	public List CommentAll(Comment c) {
		// TODO Auto-generated method stub
		return dao.CommentSelect(c);
	}

	@Override
	public void DelComment(int comment_Num) {
		// TODO Auto-generated method stub
	   dao.CommentDelete(comment_Num);
	}



	


	
	



}
