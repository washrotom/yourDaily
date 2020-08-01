package follow.Service;

import java.util.List;

import follow.DAO.followDao;
import follow.DAO.followDaoImpl;

public class followServiceImpl implements followService{

	private followDao dao;
	
	public followServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new followDaoImpl(); 
	}
	@Override
	public void addFollow(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptFollow(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listFollow(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unFollow(String id) {
		// TODO Auto-generated method stub
		
	}
	

}
