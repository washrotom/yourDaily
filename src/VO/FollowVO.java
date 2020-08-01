package VO;

public class FollowVO {
	private int num;
	private String id;
	private String following;
	private String follower;
	
	public FollowVO() {
		
	}

	public FollowVO(int num, String id, String following, String follower) {
		super();
		this.num = num;
		this.id = id;
		this.following = following;
		this.follower = follower;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getFollower() {
		return follower;
	}

	public void setFollower(String follower) {
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "FollowVO [num=" + num + ", id=" + id + ", following=" + following + ", follower=" + follower + "]";
	}
}