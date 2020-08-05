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
		String sql = "insert into live values(live_num.nextval,?,sysdate,?,?,null)";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getId());
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
	public LiveVO select(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LiveVO vo = null;
		String sql = "select * from live where id=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new LiveVO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
	public List selectAll(String id) {

		Connection conn = null;
		ResultSet rs = null;
		ArrayList<LiveVO> list = new ArrayList<LiveVO>();

		String sql = "select * from live where id = ? order by title";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				list.add(new LiveVO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
		Connection conn = null;

		// db에 한 줄 수정하는 sql
		String sql = "update live set w_date=sysdate, title=?, "
		+ "content=? where num=?";

		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setString(1, l.getTitle());
			pstmt.setString(2, l.getContent());
			pstmt.setInt(3, l.getNum());

			// sql실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int num) {
		Connection conn = null;

		// db에 한 줄 삭제하는 sql
		String sql = "delete live where num=?";

		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setInt(1, num);

			// sql실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	}

	@Override
	public LiveVO selectNum(int num) {
		Connection conn = null;
		ResultSet rs = null;
		LiveVO b = null;

		// 한 줄 검색하는 sql문
		String sql = "select * from live where num=?";
		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setInt(1, num);

			// sql실행하여 검색된 결과를 ResultSet에 저장
			rs = pstmt.executeQuery();

			// 검색 결과가 있다면 컬럼 값 하나씩 읽어서 Board 객체를 생성하여 반환
			if (rs.next()) {
					return new LiveVO(rs.getInt(1), rs.getString(2), rs.getDate(3), 
		rs.getString(4), rs.getString(5), rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;

	}
	
}
