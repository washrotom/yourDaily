package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Board;
import model.Comment;

public class CommentImpl implements CommentDAO {
	private DBConnect db;

	public CommentImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public void insert(Comment c) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// db에 한 줄 추가하는 sql
		String sql = "insert into comment3 values(comment_seq.nextval, ?,?,?)";

		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ?파라메터 매칭
			pstmt.setString(1, c.getComment_ID());
			pstmt.setString(2, c.getComment_Content());
			pstmt.setInt(3, c.getComment_Bnum());

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
	public List CommentSelect(Comment c) {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;

		// 전체 검색하는 sql문
		String sql = "select c.* from board b , comment3 c where b.num=? and c.comment_bnum= ?  order by c.comment_bnum desc";
		
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, c.getComment_Bnum());
			pstmt.setInt(2, c.getComment_Bnum());

			// sql실행하여 검색된 결과를 ResultSet에 저장
			rs = pstmt.executeQuery();

			// 검색 결과가 있다면 컬럼 값 하나씩 읽어서 Board 객체를 생성하여 반환
			while (rs.next()) {
list.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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

	

}
