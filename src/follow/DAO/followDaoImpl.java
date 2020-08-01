package follow.DAO;

import java.util.List;

import DB.DBConnect;

public class followDaoImpl implements followDao{
	private DBConnect db;
	
	public followDaoImpl() {
		// TODO Auto-generated constructor stub
		db = DBConnect.getInstance();
	}

	@Override
	public void add(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
}
