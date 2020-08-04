package board.service;

import java.util.ArrayList;
import java.util.List;


import model.Board;


public interface Service {
	void writeBoard(Board b);	//�� �ۼ�

	Board getBoard(int num);	//�� �˻�

	List getAll();				//�� ��ü �˻�

	void editBoard(Board b);	//�� ����

	void delBoard(int num);		//�� ����

	
}
