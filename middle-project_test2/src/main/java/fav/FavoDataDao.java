package fav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import dataroom.Data;

public class FavoDataDao {
	private DBConnect db;

	public FavoDataDao() {
		db = DBConnect.getInstance();
	}

	public void insert(FavoData d) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into FavoData values(seq_favodata.nextval,?,?)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setInt(1, d.getDatanum());
			pstmt.setString(2, d.getId());
			// sql 실행
			int cnt = pstmt.executeUpdate();// insert, update, delete문장 실행.
			// pstmt.executeQuery()//select문 실행 => ResultSet 반환
			System.out.println(cnt + " 줄 추가됨");
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

	
	public int delete(FavoData d) {
		Connection conn = db.conn();
		String sql = "delete from FavoData where id=? and datanum=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getId());
			pstmt.setInt(2, d.getDatanum());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + " 줄이 삭제됨");
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
	
	public int selectFcnt(int datanum) {
		//db 연결
				Connection conn = db.conn();
				
				//sql문 작성
				String sql = "select count(*) from favodata where datanum = ?";
				
				//ArrayList 생성
				ArrayList<Data> list = new ArrayList<Data>();
				
				try {
					//PreparedStatement 객체 생성
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, datanum);
					//sql 실행
					ResultSet rs = pstmt.executeQuery();
					
					//ResultSet 읽을 줄로 이동
					if(rs.next()) {
						return rs.getInt(1);
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
				return 0;
		}
			
	public ArrayList<String> selectIds(int datanum) {
		//db 연결
				Connection conn = db.conn();
				
				//sql문 작성
				String sql = "select id from favodata where datanum = ?";
				
				//ArrayList 생성
				ArrayList<String> ids = new ArrayList<String>();
				
				try {
					//PreparedStatement 객체 생성
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, datanum);
					//sql 실행
					ResultSet rs = pstmt.executeQuery();
					
					//ResultSet 읽을 줄로 이동
					while (rs.next()) {
						ids.add(rs.getString(1));
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
				return ids;
		}
	public FavoData select(int datanum, String id) {
		//db 연결
				Connection conn = db.conn();
				
				//sql문 작성
				String sql = "select * from favodata where datanum = ? and id=?";
				
				//ArrayList 생성
				ArrayList<Data> list = new ArrayList<Data>();
				
				try {
					//PreparedStatement 객체 생성
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, datanum);
					pstmt.setString(2, id);
					//sql 실행
					ResultSet rs = pstmt.executeQuery();
					
					//ResultSet 읽을 줄로 이동
					if(rs.next()) {
						return new FavoData(rs.getInt(1), rs.getInt(2),rs.getString(3));
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
