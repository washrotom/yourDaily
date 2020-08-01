package board.dao;

import java.util.List;

import model.Board;

public interface Dao {
	void insert(Board b);	//글 정보 db에 저장

	Board select(int num);	//글 하나에 대한 정보 검색하여 Board객체 반환

	List selectAll();		//글 전체 검색하여 List로 반환

	void update(Board b);	//글 정보 db에서 수정

	void delete(int num);	//글 번호로 db에서 삭제
}
