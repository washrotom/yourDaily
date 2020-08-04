package VO;

public class FollowVO {
	private String num;
	private String id;
	private int following = 0;
	private int follower = 0;
	private String myid;
	
	public FollowVO() {
		
	}

	public FollowVO(String num, String id, int following, int follower, String myid) {
		super();
		this.num = num;
		this.myid = myid;
		this.id = id;
		this.following = following;
		this.follower = follower;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	@Override
	public String toString() {
		return "FollowVO [num=" + num + ", myid=" + myid + ", id=" + id + ", following=" + following + ", follower="
				+ follower + "]";
	}
	
}