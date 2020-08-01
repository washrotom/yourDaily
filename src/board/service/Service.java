package board.service;

import java.util.List;

import model.Board;
import model.Comment;

public interface Service {
	void writeBoard(Board b);	//�� �ۼ�

	Board getBoard(int num);	//�� �˻�

	List getAll();				//�� ��ü �˻�

	void editBoard(Board b);	//�� ����

	void delBoard(int num);		//�� ����

	
}
