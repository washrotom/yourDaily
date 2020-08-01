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

		// db�� �� �� �߰��ϴ� sql
		String sql = "insert into board values(seq_board.nextval, ?, "
				+ "sysdate, ?, ?)";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());

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

	@Override
	public Board select(int num) {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;
		Board b = null;

		// �� �� �˻��ϴ� sql��
		String sql = "select * from board where num=?";
		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setInt(1, num);

			// sql�����Ͽ� �˻��� ����� ResultSet�� ����
			rs = pstmt.executeQuery();

			// �˻� ����� �ִٸ� �÷� �� �ϳ��� �о Board ��ü�� �����Ͽ� ��ȯ
			if (rs.next()) {
return new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), 
		rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �ڿ� ��ȯ
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

		// ��ü �˻��ϴ� sql��
		String sql = "select * from board order by num";
		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�����Ͽ� �˻��� ����� ResultSet�� ����
			rs = pstmt.executeQuery();

			// �˻� ����� �ִٸ� �÷� �� �ϳ��� �о Board ��ü�� �����Ͽ� ��ȯ
			while (rs.next()) {
list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3),
		rs.getString(4), rs.getString(5)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �ڿ� ��ȯ
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

		// �˻� ����� ����� list ��ȯ
		return list;
	}

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub

		Connection conn = null;

		// db�� �� �� �����ϴ� sql
String sql = "update board set w_date=sysdate, title=?, "
		+ "content=? where num=?";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());

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

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

		Connection conn = null;

		// db�� �� �� �����ϴ� sql
		String sql = "delete board where num=?";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setInt(1, num);

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
