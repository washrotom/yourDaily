package follow.DAO;

import java.util.List;

import VO.FollowVO;

public interface followDao {
	public void insert(FollowVO vo);
	public void accept(String id, String myid);
	List selectFollowing(String id);
	List selectFollower(String id);
	public void delete(String id);
	FollowVO listSelect(String id, String myid);
	List myFollowingList(String id);
}
