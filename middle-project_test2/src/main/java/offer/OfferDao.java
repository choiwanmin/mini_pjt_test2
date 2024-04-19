package offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class OfferDao {
	private DBConnect db;
	
	public OfferDao() {
		db = DBConnect.getInstance();
	}
	
	//insert
	public void insert(Offer o) {
		Connection conn = db.conn();
		String sql = "insert into offer values(seq_offer.nextval,?,?,?,sysdate,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getCorp_id());
			pstmt.setString(2, o.getWanted_auth_no());
			pstmt.setString(3, o.getUserid());
			pstmt.setInt(4, o.getAccept());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}

	//select(1개의 offer)-(상세)
	public Offer select(int num) {
		Connection conn = db.conn();
		String sql = "select * from offer where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			if(rs.next()) {
				return new Offer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
	//userSelect(유저가 받은 공고 제안 리스트)
	public ArrayList<Offer> selectByUser(int userid) {
		Connection conn = db.conn();
		String sql = "select * from offer where userid=? order by num";
		ArrayList<Offer> list = new ArrayList<Offer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				list.add(new Offer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6)));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	//wantedSelect(회사가 제안한 공고 제안 리스트-공고별)
	public ArrayList<Offer> wantedByUser(String wanted_auth_no) {
		Connection conn = db.conn();
		String sql = "select * from offer where wanted_auth_no=? order by num";
		ArrayList<Offer> list = new ArrayList<Offer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wanted_auth_no);
			ResultSet rs = pstmt.executeQuery();
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				list.add(new Offer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6)));
			}
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
		return list;
	}
	//update
	//공고 승낙>int 
	public void update(int accept,int num) {
		Connection conn = db.conn();
		String sql = "update offer set accept=? where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,accept);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
	//delete
	public void delete(int num) {
		Connection conn = db.conn();
		String sql = "delete * from offer where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();} 
		finally {
			try {conn.close();} 
			catch (SQLException e) {e.printStackTrace();}
		}
	}
}
