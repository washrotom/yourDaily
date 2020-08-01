package board.service;

import java.util.List;

import model.Board;
import model.Comment;

public interface Service {
	void writeBoard(Board b);	//글 작성

	Board getBoard(int num);	//글 검색

	List getAll();				//글 전체 검색

	void editBoard(Board b);	//글 수정

	void delBoard(int num);		//글 삭제

	
}
