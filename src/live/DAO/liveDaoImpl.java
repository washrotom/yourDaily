package live.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import VO.LiveVO;

public class liveDaoImpl implements liveDao{
	
	private DBConnect db;
	
	public liveDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(LiveVO l) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into live values(?,?,?)";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getName());
			pstmt.setString(2, l.getTitle());
			pstmt.setString(3, l.getContent());
			
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
	public LiveVO select(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LiveVO vo = null;
		String sql = "select * from live where name=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new LiveVO(rs.getString(1), rs.getString(2), rs.getString(3));
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
	public List selectAll(String name) {

		Connection conn = null;
		ResultSet rs = null;
		ArrayList<LiveVO> list = new ArrayList<LiveVO>();

		String sql = "select * from live where name = ? order by title";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				list.add(new LiveVO(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}


	@Override
	public void update(LiveVO l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name, String title) {
		// TODO Auto-generated method stub
		
	}
	
	

}
