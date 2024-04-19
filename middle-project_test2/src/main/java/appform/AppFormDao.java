package appform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import mem.Mem;

public class AppFormDao {
	
	//지원서 작성 추가
	private DBConnect db;

	public AppFormDao() {
		db = DBConnect.getInstance();
	}
	
	
	public void insert(AppForm f) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into appform values(?,?,?,?,?)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setInt(1, f.getNum());
			pstmt.setInt(2, f.getUserid());
			pstmt.setString(3, f.getCoverletter());
			pstmt.setString(4, f.getPofol());
			pstmt.setString(5, f.getPicture());
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

	
	//지원서 수정 = 자소서만 변경 가능 
	public int update(AppForm f) {// id로 찾아서 pwd수정
		Connection conn = db.conn();
		String sql = "update appform set coverletter=? where userid=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getCoverletter());
			pstmt.setInt(2, f.getUserid());
			cnt = pstmt.executeUpdate();//처리된 줄 수 반환
			System.out.println(cnt + " 줄이 수정됨");
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
	
	
	
	//지원서 삭제
	public int delete(int userid) {
		Connection conn = db.conn();
		String sql = "delete from appform where userid=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
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
	
	
	
	//pk기준 검색 메서드는 반환타입은 vo, 파라메터는 pk 컬럼. mem은 String id를 파람으로 받음
	public AppForm select(int userid) {
		Connection conn = db.conn();
		String sql = "select * from appform where userid=?";
		AppForm app = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			//select는 executeQuery()로 실행
			//executeQuery()는 select를 실행하고 검색 결과를 ResultSet에 담아서 반환
			ResultSet rs = pstmt.executeQuery();
			//rs.next(): 읽을 다음 줄로 이동. 읽을 것이 있으면 true, 없으면 false반환
			if(rs.next()) {
				app = new AppForm();
				app.setNum(rs.getInt(1));//1번 컬럼의 문자열 값을 읽음
				app.setUserid(rs.getInt(2));
				app.setCoverletter(rs.getString(3));
				app.setPofol(rs.getString(4));
				app.setPicture(rs.getString(5));
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
		return app;
	}
	
	public ArrayList<AppForm> selectAll(){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from appform";
		
		//ArrayList 생성
		ArrayList<AppForm> list = new ArrayList<AppForm>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while(rs.next()) {
				AppForm app = new AppForm();
				app.setNum(rs.getInt(1));
				app.setUserid(rs.getInt(2));
				app.setCoverletter(rs.getString(3));
				app.setPofol(rs.getString(4));
				app.setPicture(rs.getString(5));
				list.add(app);
				//list.add(new Mem(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
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
