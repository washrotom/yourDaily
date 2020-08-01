package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import board.dao.Dao;
import conn.DBConnect;
import model.Board;
import model.Comment;

public class CommentImpl implements CommentDAO{	
		private DBConnect db;

		public CommentImpl() {
			db = DBConnect.getInstance();
		}
		
		@Override
		public void insert(Comment c) {
			// TODO Auto-generated method stub
			Connection conn = null;

			// db에 한 줄 추가하는 sql
			String sql = "insert into comment2 values(comment_seq,?,?,?,sysdate)";
					

			PreparedStatement pstmt = null;
			try {
				// 커넥션 객체 획득
				conn = db.getConnection();

				// java에서 sql을 실행하는 PreparedStatement객체 생성
				pstmt = conn.prepareStatement(sql);

				// sql의 ?파라메터 매칭
				pstmt.setString(1, c.getName());
				pstmt.setString(2, c.getPassword());
				pstmt.setString(3, c.getContent());
				

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
