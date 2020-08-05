package comments.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import VO.CommentVO;


public class CommentImpl implements CommentDAO {
	private DBConnect db;

	public CommentImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public void insert(CommentVO c) {
		// TODO Auto-generated method stub
		Connection conn = null;

		// db�뿉 �븳 以� 異붽��븯�뒗 sql
		String sql = "insert into comment3 values(comment_seq.nextval, ?,?,?)";

		PreparedStatement pstmt = null;
		try {
			// 而ㅻ꽖�뀡 媛앹껜 �쉷�뱷
			conn = db.getConnection();

			// java�뿉�꽌 sql�쓣 �떎�뻾�븯�뒗 PreparedStatement媛앹껜 �깮�꽦
			pstmt = conn.prepareStatement(sql);

			// sql�쓽 ?�뙆�씪硫뷀꽣 留ㅼ묶
			pstmt.setString(1, c.getComment_ID());
			pstmt.setString(2, c.getComment_Content());
			pstmt.setInt(3, c.getComment_Bnum());

			// sql�떎�뻾
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �옄�썝 諛섑솚
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	@Override
	public List CommentSelect(CommentVO c) {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;

		// �쟾泥� 寃��깋�븯�뒗 sql臾�
		String sql = "select c.* from board b , comment3 c where b.num=? and c.comment_bnum= ?  order by c.comment_bnum desc";
		
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		
		PreparedStatement pstmt = null;
		try {
			// 而ㅻ꽖�뀡 媛앹껜 �쉷�뱷
			
			conn = db.getConnection();

			// java�뿉�꽌 sql�쓣 �떎�뻾�븯�뒗 PreparedStatement媛앹껜 �깮�꽦
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, c.getComment_Bnum());
			pstmt.setInt(2, c.getComment_Bnum());

			// sql�떎�뻾�븯�뿬 寃��깋�맂 寃곌낵瑜� ResultSet�뿉 ���옣
			rs = pstmt.executeQuery();

			// 寃��깋 寃곌낵媛� �엳�떎硫� 而щ읆 媛� �븯�굹�뵫 �씫�뼱�꽌 Board 媛앹껜瑜� �깮�꽦�븯�뿬 諛섑솚
			while (rs.next()) {
list.add(new CommentVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �옄�썝 諛섑솚
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

		// 寃��깋 寃곌낵媛� ���옣�맂 list 諛섑솚
		return list;
	}
	@Override
	public void CommentDelete(int comment_Num) {
		// TODO Auto-generated method stub

		Connection conn = null;

		// db�뿉 �븳 以� �궘�젣�븯�뒗 sql
		String sql = "delete comment3 where comment_Num=?";

		PreparedStatement pstmt = null;
		try {
			// 而ㅻ꽖�뀡 媛앹껜 �쉷�뱷
			conn = db.getConnection();

			// java�뿉�꽌 sql�쓣 �떎�뻾�븯�뒗 PreparedStatement媛앹껜 �깮�꽦
			pstmt = conn.prepareStatement(sql);

			// sql�쓽 ?�뙆�씪硫뷀꽣 留ㅼ묶
			pstmt.setInt(1, comment_Num );

			// sql�떎�뻾
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �옄�썝 諛섑솚
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
