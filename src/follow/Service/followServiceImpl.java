package follow.Service;

import java.util.List;

import VO.FollowVO;
import follow.DAO.followDao;
import follow.DAO.followDaoImpl;

public class followServiceImpl implements followService{

	private followDao dao;
	
	public followServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new followDaoImpl(); 
	}
	@Override
	public void addFollow(FollowVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void acceptFollow(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listFollowing(String id) {
		return dao.selectFollowing(id);
	}
	@Override
	public List listFollower(String id) {
		return dao.selectFollower(id);
	}

	@Override
	public void unFollow(String id) {
		// TODO Auto-generated method stub
		
	}
	

}
