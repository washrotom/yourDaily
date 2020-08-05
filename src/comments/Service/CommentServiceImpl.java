package comments.Service;



import java.util.ArrayList;
import java.util.List;

import VO.CommentVO;
import comments.DAO.CommentDAO;
import comments.DAO.CommentImpl;

public  class CommentServiceImpl implements CommentService{
	
	private CommentDAO dao;
	
	public CommentServiceImpl() {
		dao = new CommentImpl();
	}

	@Override
	public void writeComment(CommentVO c) {
		// TODO Auto-generated method stub
		dao.insert(c);
	}

	@Override
	public List CommentAll(CommentVO c) {
		// TODO Auto-generated method stub
		return dao.CommentSelect(c);
	}

	@Override
	public void DelComment(int comment_Num) {
		// TODO Auto-generated method stub
	   dao.CommentDelete(comment_Num);
	}

}
