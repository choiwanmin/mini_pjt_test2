package recruit.recruitdetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;

public class RecruitDetailDao {
	private DBConnect db;

	public RecruitDetailDao() {
		db = DBConnect.getInstance();
	}

	//
	//
	public void insert(RecruitDetail rd) {
		Connection conn = db.conn();
		String sql = "insert into recruit_detail values(seq_recruit_detail.nextval,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rd.getWantedAuthNo());
			pstmt.setInt(2, rd.getMinSal());
			pstmt.setInt(3, rd.getMaxSal());
			pstmt.setString(4, rd.getRelJobNm());
			pstmt.setString(5, rd.getSrchKeyWordNm());
			pstmt.setString(6, rd.getJobCont());
			pstmt.setDate(7, rd.getSmodifyDtm());
			pstmt.setString(8, rd.getBasicAddr());
			pstmt.setString(9, rd.getDetailAddr());
			pstmt.setString(10, rd.getContactTelNo());
			pstmt.setInt(11, rd.getType());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 공고상세추가");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//
	// 공고번호로 찾아서 공고상세 수정
	public int update(RecruitDetail rd) {
		Connection conn = db.conn();
		String sql = "update recruit_detail set " + "min_sal=? " + "max_sal=? " + "rel_job_nm=? "
				+ "srch_key_word_nm=? " + "job_cont=? " + "smodify_dtm=sysdate " + "basic_addr=? " + "detail_addr=? "
				+ "contact_tel_no=? " + "type=? " + "where wanted_auth_no=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rd.getMinSal());
			pstmt.setInt(2, rd.getMaxSal());
			pstmt.setString(3, rd.getRelJobNm());
			pstmt.setString(4, rd.getSrchKeyWordNm());
			pstmt.setString(5, rd.getJobCont());
			pstmt.setString(6, rd.getBasicAddr());
			pstmt.setString(7, rd.getDetailAddr());
			pstmt.setString(8, rd.getContactTelNo());
			pstmt.setInt(9, rd.getType());
			pstmt.setString(10, rd.getWantedAuthNo());

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 수정");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;

	}

	//
	// 공고번호로 찾아서 공고상세 삭제
	public int delete(String wantedAuthNo) {
		Connection conn = db.conn();
		String sql = "delete from recruit_detail where wanted_auth_no=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wantedAuthNo);

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//
	// 공고번호로 찾아서 공고상세 반환
	public RecruitDetail selectByWantedAuthNo(String wantedAuthNo) {
		Connection conn = db.conn();
		String sql = "select * from recruit_detail where wanted_auth_no=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wantedAuthNo);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new RecruitDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getInt(12), rs.getInt(13));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
