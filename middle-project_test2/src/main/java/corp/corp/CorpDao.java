package corp.corp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;

public class CorpDao {
	private DBConnect db;

	public CorpDao() {
		db = DBConnect.getInstance();
	}

	// db에서 sequence 값을 받아오는 메소드
	// insert
	public int insertSeq() {
		Connection conn = db.conn();
		String sql = "select seq_corp_num.nextval from dual";
		int num = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// insert
	//
	public void insert(Corp o, int num) {
		Connection conn = db.conn();
		// member(id)와 corp(corp_id) 무결성 제약 조건 만족을 위한 기업 회원 정보 자동 할당
		String sql1 = "insert into member values(concat('auto_corp_id',?),'0000',1)";
		String sql2 = "insert into corp values(seq_corp.nextval,concat('auto_corp_id',?),?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, num);
			int cnt1 = pstmt.executeUpdate();

			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.setString(2, o.getCorp_nm());
			pstmt.setString(3, o.getCorp_addr());
			pstmt.setString(4, o.getBusi_no());

			int cnt2 = pstmt.executeUpdate();
			System.out.println(cnt1 + "줄 회원추가");
			System.out.println(cnt1 + "줄 기업추가");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	// member(id)와 corp(corp_id) 무결성 제약 조건 만족을 위한 기업 회원 정보 자동 할당
//	// insert
//	public void insertMember(int num) {
//		Connection conn = db.conn();
//		String sql = "insert into member values(concat('auto_corp_id',?),'0000',1)";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//
//			int cnt = pstmt.executeUpdate();
//			System.out.println(cnt + "줄 추가");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// member(id)와 corp(corp_id) 무결성 제약 조건 만족을 위한 기업 회원 정보 자동 할당
//	// insert
//	public void insert(Corp o, int num) {
//		Connection conn = db.conn();
//		String sql = "insert into corp values(seq_corp.nextval,concat('auto_corp_id',?),?,?,?)";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.setString(2, o.getCorp_nm());
//			pstmt.setString(3, o.getCorp_addr());
//			pstmt.setString(4, o.getBusi_no());
//
//			int cnt = pstmt.executeUpdate();
//			System.out.println(cnt + "줄 추가");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	// update
	// 회사 주소
	public void update(int num, String addr) {
		Connection conn = db.conn();
		String sql = "update corp set corp_addr=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// delete
	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete * from corp where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// select
	public Corp select(int num) {
		Connection conn = db.conn();
		String sql = "select * from corp where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			// ResultSet 읽을 줄로 이동
			if (rs.next()) {
				return new Corp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	//
	//
	public Corp selectByBusino(String busi_no) {
		Connection conn = db.conn();
		String sql = "select * from corp where busi_no=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busi_no);
			ResultSet rs = pstmt.executeQuery();
			// ResultSet 읽을 줄로 이동
			if (rs.next()) {
				return new Corp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
