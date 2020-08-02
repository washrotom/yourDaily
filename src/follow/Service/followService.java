package follow.Service;

import java.util.List;

import VO.FollowVO;

public interface followService {
	void addFollow(FollowVO vo);
	void acceptFollow(String id);
	List listFollowing(String myid);
	List listFollower(String id);
	void unFollow(String id);
}
