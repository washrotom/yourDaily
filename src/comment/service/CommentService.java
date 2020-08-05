package comment.service;


import java.util.ArrayList;
import java.util.List;

import model.Comment;

public interface CommentService {
	void writeComment(Comment c);

	List CommentAll(Comment c);

	void DelComment(int comment_Num);

	
	
	
	
	
}
