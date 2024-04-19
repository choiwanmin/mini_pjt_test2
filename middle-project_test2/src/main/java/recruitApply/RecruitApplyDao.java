package recruitApply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import offer.Offer;

public class RecruitApplyDao {
	private DBConnect db;
	
	public RecruitApplyDao() {
		db = DBConnect.getInstance();
	}
	
	//insert
	public void insert(RecruitApply r) {
		Connection conn = db.conn();
		String sql = "insert into recruit_apply values(?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getWanted_auth_no());
			pstmt.setString(2, r.getWanted_title());
			pstmt.setString(3, r.getApplycant_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}

	//select
	public RecruitApply select(int num,String wanted_auth_no) {
		Connection conn = db.conn();
		String sql = "select * from recruit_apply where applycant_num=? and wanted_auth_no=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setString(1,wanted_auth_no);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			if(rs.next()) {
				return new RecruitApply(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
	//회사별로 지원자 리스트
	public ArrayList<RecruitApply> SelectByCorp(String busi_no) {
		Connection conn = db.conn();
		String sql = "select * from recruit_apply where busi_no=? order by appldate";
		ArrayList<RecruitApply> list = new ArrayList<RecruitApply>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, busi_no);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				list.add(new RecruitApply(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	//authNoSelect(회사가 공고별로 지원한 리스트 확인받기)
	public ArrayList<RecruitApply> SelectByauthNo(String wanted_auth_no) {
		Connection conn = db.conn();
		String sql = "select * from recruit_apply where wanted_auth_no=? order by appldate";
		ArrayList<RecruitApply> list = new ArrayList<RecruitApply>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wanted_auth_no);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				list.add(new RecruitApply(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	//userSelect(유저가 지원한 리스트)
	public ArrayList<RecruitApply> selectByUser(int applycant_num) {
		Connection conn = db.conn();
		String sql = "select * from recruit_apply where recruit_apply=? order by appldate";
		ArrayList<RecruitApply> list = new ArrayList<RecruitApply>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applycant_num);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				list.add(new RecruitApply(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	//delete
	//지원 취소
	public void delete(int num,String wanted_auth_no) {
		Connection conn = db.conn();
		String sql = "delete * from applycant_num where applycant_num=? and wanted_auth_no=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.setString(1,wanted_auth_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
}