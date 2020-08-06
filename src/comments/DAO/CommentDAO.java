package comments.DAO;


import java.util.ArrayList;
import java.util.List;

import VO.CommentVO;

public interface CommentDAO {

	void insert(CommentVO c);

	List CommentSelect(CommentVO c);

	void CommentDelete(int comment_Num);

	

    

	

	

}
