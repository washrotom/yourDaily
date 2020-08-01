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

			// db�� �� �� �߰��ϴ� sql
			String sql = "insert into comment2 values(comment_seq,?,?,?,sysdate)";
					

			PreparedStatement pstmt = null;
			try {
				// Ŀ�ؼ� ��ü ȹ��
				conn = db.getConnection();

				// java���� sql�� �����ϴ� PreparedStatement��ü ����
				pstmt = conn.prepareStatement(sql);

				// sql�� ?�Ķ���� ��Ī
				pstmt.setString(1, c.getName());
				pstmt.setString(2, c.getPassword());
				pstmt.setString(3, c.getContent());
				

				// sql����
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// �ڿ� ��ȯ
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

}
