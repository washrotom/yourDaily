package comments.Service;


import java.util.ArrayList;
import java.util.List;

import VO.CommentVO;


public interface CommentService {
	void writeComment(CommentVO c);

	List CommentAll(CommentVO c);

	void DelComment(int comment_Num);

	
	
	
	
	
}
