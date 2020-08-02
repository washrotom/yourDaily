package follow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import VO.FollowVO;

public class followDaoImpl implements followDao{
	private DBConnect db;
	
	public followDaoImpl() {
		// TODO Auto-generated constructor stub
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(FollowVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into follow values (follow_num.nextval, ?, ?, 0, ?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getFollowing());
			pstmt.setString(3, vo.getMyid());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void accept(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectFollowing(String myid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FollowVO> followinglist = new ArrayList<FollowVO>();
		
		String sql = "select * from follow where following=1 and myid=? order by num;";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, myid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				followinglist.add(new FollowVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return followinglist;
	}
	@Override
	public List selectFollower(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FollowVO vo = null;
		String sql = "select id from follow where follower=1 order by num;";
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
}
