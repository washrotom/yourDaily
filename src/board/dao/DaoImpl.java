package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Board;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Board b) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// db에 한 줄 추가하는 sql
		String sql = "insert into board values(seq_board.nextval, ?, "
				+ "sysdate, ?, ?)";

		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());

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
	public Board select(int num) {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;
		Board b = null;

		// 한 줄 검색하는 sql문
		String sql = "select * from board where num=?";
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
return new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), 
		rs.getString(4), rs.getString(5));
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

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();

		// 전체 검색하는 sql문
		String sql = "select * from board order by num";
		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql실행하여 검색된 결과를 ResultSet에 저장
			rs = pstmt.executeQuery();

			// 검색 결과가 있다면 컬럼 값 하나씩 읽어서 Board 객체를 생성하여 반환
			while (rs.next()) {
list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3),
		rs.getString(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				if (rs != null) {
					rs.close();
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// 검색 결과가 저장된 list 반환
		return list;
	}

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub

		Connection conn = null;

		// db에 한 줄 수정하는 sql
String sql = "update board set w_date=sysdate, title=?, "
		+ "content=? where num=?";

		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());

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
		// TODO Auto-generated method stub

		Connection conn = null;

		// db에 한 줄 삭제하는 sql
		String sql = "delete board where num=?";

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

}
