package follow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import DB.DBConnect;
import VO.FollowVO;
import VO.SignVO;

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
		String sql = "insert into follow values (?, ?, ?, 0, ?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (vo.getId()+vo.getMyid()));
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, vo.getFollowing());
			pstmt.setString(4, vo.getMyid());
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
	public void accept(String id, String myid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update table follow set follower=1 where id=?, myid=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, myid);
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
	public List selectFollowing(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FollowVO> followinglist = new ArrayList<FollowVO>();
		
		String sql = "select * from follow where following=1 and id=? and myid is not null";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				followinglist.add(new FollowVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
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
		ArrayList<FollowVO> followinglist = new ArrayList<FollowVO>();
		
		String sql = "select * from follow where follower=1 and id=? and myid is not null";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				followinglist.add(new FollowVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
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
		return followinglist;	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FollowVO listSelect(String id, String myid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from follow where id=? and myid=?";
		ResultSet rs = null;
		FollowVO vo = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, myid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new FollowVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
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
		return null;
	}

	@Override
	public void accept(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List myFollowingList(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FollowVO> myfollowinglist = new ArrayList<FollowVO>();
		
		String sql = "select * from follow where following=1 and myid=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				myfollowinglist.add(new FollowVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
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
		return myfollowinglist;
	}
}
