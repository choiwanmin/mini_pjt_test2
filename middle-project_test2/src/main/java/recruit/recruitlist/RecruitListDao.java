package recruit.recruitlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class RecruitListDao {
	private DBConnect db;

	public RecruitListDao() {
		db = DBConnect.getInstance();
	}

	//
	//
	public void insert(RecruitList rl) {
		Connection conn = db.conn();
		String sql = "insert into recruit_list values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rl.getBusiNo());
			pstmt.setString(2, rl.getWantedAuthNo());
			pstmt.setString(3, rl.getWantedTitle());
			pstmt.setString(4, rl.getSalTpCd());
			pstmt.setString(5, rl.getSal());
			pstmt.setString(6, rl.getMinEdubgIcd());
			pstmt.setString(7, rl.getEnterTpCd());
			pstmt.setString(8, rl.getWorkRegion());
			pstmt.setInt(9, rl.getRegionCd());
			pstmt.setString(10, rl.getJobsNm());
			pstmt.setInt(11, rl.getJobsCd());
			pstmt.setDate(12, rl.getRegDt());
			pstmt.setDate(13, rl.getCloseDt());
			pstmt.setInt(14, rl.getSaveStatus());
			pstmt.setString(15, rl.getHomePg());
			pstmt.setBoolean(16, rl.isType());

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "줄 공고목록추가");
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
	// 사업자등록번호와 공고번호로 찾아서 공고목록 수정
	public int update(RecruitList rl) {
		Connection conn = db.conn();
		String sql = "update recruit_list set " + "wantedTitle=? " + "salTpCd=? " + "sal=? " + "minEdubgIcd=? "
				+ "enterTpCd=? " + "workRegion=? " + "regionCd=? " + "jobsNm=? " + "jobsCd=? " + "regDt=? "
				+ "closeDt=? " + "saveStatus=? " + "homePg=? " + "type=? " + "where busi_no=? and wanted_auth_no=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rl.getWantedTitle());
			pstmt.setString(2, rl.getSalTpCd());
			pstmt.setString(3, rl.getSal());
			pstmt.setString(4, rl.getMinEdubgIcd());
			pstmt.setString(5, rl.getEnterTpCd());
			pstmt.setString(6, rl.getWorkRegion());
			pstmt.setInt(7, rl.getRegionCd());
			pstmt.setString(8, rl.getJobsNm());
			pstmt.setInt(9, rl.getJobsCd());
			pstmt.setDate(10, rl.getRegDt());
			pstmt.setDate(11, rl.getCloseDt());
			pstmt.setInt(12, rl.getSaveStatus());
			pstmt.setString(13, rl.getHomePg());
			pstmt.setBoolean(14, rl.isType());
			pstmt.setString(15, rl.getBusiNo());
			pstmt.setString(16, rl.getWantedAuthNo());

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
	// 사업자등록번호와 공고번호로 찾아서 공고목록 삭제
	public int delete(String busiNo, String wantedAuthNo) {
		Connection conn = db.conn();
		String sql = "delete from recruit_list where busi_no=? and wanted_auth_no=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busiNo);
			pstmt.setString(2, wantedAuthNo);

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
	// 사업자등록번호와 공고번호로 찾아서 공고목록 반환
	public RecruitList selectByWantedAuthNo(String busiNo, String wantedAuthNo) {
		Connection conn = db.conn();
		String sql = "select * from recruit_list where busi_no=? and wanted_auth_no=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busiNo);
			pstmt.setString(2, wantedAuthNo);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new RecruitList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getString(10), rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getInt(14),
						rs.getString(15), rs.getBoolean(16));
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

	//
	// 사업자등록번호로 찾아서 전체 공고목록 반환
	public ArrayList<RecruitList> selectByBusiNo(String busiNo) {
		Connection conn = db.conn();
		String sql = "select * from recruit_list where busi_no=? order by reg_dt";
		ArrayList<RecruitList> list = new ArrayList<RecruitList>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busiNo);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new RecruitList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getString(10), rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getInt(14),
						rs.getString(15), rs.getBoolean(16)));
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
		return list;
	}
}
