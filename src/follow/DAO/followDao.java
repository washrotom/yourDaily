package follow.DAO;

import java.util.List;

import VO.FollowVO;

public interface followDao {
	public void insert(FollowVO vo);
	public void accept(String id);
	List selectFollowing(String myid);
	List selectFollower(String id);
	public void delete(String id);
}
