package person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class MyappListDao {
	private DBConnect db;
	public MyappListDao() {
		db=DBConnect.getInstance();
	}
	public void insert(MyappList a) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into my_applist values(seq_my_applist.nextval,?,?,?,0)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setString(2, a.getWanted_auth_no());
			pstmt.setInt(1, a.getUserId());
			pstmt.setString(3, a.getWanted_title());
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
	
	public void delete(int num) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "delete my_applist where num=?";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setInt(1, num);
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
	public MyappList selectBynum(int num) {
		Connection conn = db.conn();
		String sql = "select * from my_applist where num=?";
		MyappList a = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//select는 executeQuery()로 실행
			//executeQuery()는 select를 실행하고 검색 결과를 ResultSet에 담아서 반환
			ResultSet rs = pstmt.executeQuery();
			//rs.next(): 읽을 다음 줄로 이동. 읽을 것이 있으면 true, 없으면 false반환
			if(rs.next()) {
				a = new MyappList();
				a.setNum(rs.getInt(1));//1번 컬럼의 문자열 값을 읽음
				a.setUserId(rs.getInt(2));
				a.setWanted_auth_no(rs.getString(3));//2번 컬럼의 문자열 값을 읽음
				a.setWanted_title(rs.getString(4));//3번 컬럼의 문자열 값을 읽음
				a.setRecruit_status(rs.getInt(5));
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
		return a;
	}
	public ArrayList<MyappList> selectById(int id){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from my_applist where userid=?";
		
		//ArrayList 생성
		ArrayList<MyappList> list = new ArrayList<>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				MyappList a = new MyappList();
				a.setNum(rs.getInt(1));//1번 컬럼의 문자열 값을 읽음
				a.setUserId(rs.getInt(2));//2번 컬럼의 문자열 값을 읽음
				a.setWanted_auth_no(rs.getString(3));//3번 컬럼의 문자열 값을 읽음
				a.setWanted_title(rs.getString(4));
				a.setRecruit_status(rs.getInt(5));
				list.add(a);
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
