package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.Member;

public class JoinDaoImpl implements JoinDao {
	private DBConnect db;

	public JoinDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// db�� �� �� �߰��ϴ� sql
		String sql = "insert into member2 values(?, ?, ?, ?)";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());

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
	public Member select(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from member2 where id=?";
		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
	public void update(Member m) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// pwd, name, email �÷��� �����ϴ� sql
		String sql = "update member2 set pwd=?, name=?, email=? where id=?";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());

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
	public void delete(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// id�� ������ ���� �����ϴ� sql
		String sql = "delete member2 where id=?";

		PreparedStatement pstmt = null;
		try {
			// Ŀ�ؼ� ��ü ȹ��
			conn = db.getConnection();

			// java���� sql�� �����ϴ� PreparedStatement��ü ����
			pstmt = conn.prepareStatement(sql);

			// sql�� ?�Ķ���� ��Ī
			pstmt.setString(1, id);

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
