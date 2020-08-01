package board.service;

import java.util.List;

import board.dao.Dao;
import board.dao.DaoImpl;
import model.Board;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void writeBoard(Board b) {
		// TODO Auto-generated method stub
		dao.insert(b);
	}

	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editBoard(Board b) {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	@Override
	public void delBoard(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}

}
