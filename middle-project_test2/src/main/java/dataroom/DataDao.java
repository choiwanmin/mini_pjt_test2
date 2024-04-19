package dataroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import oracle.net.aso.d;

public class DataDao {
	private DBConnect db;

	public DataDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Data d) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into dataroom values(seq_dataroom.nextval,?,sysdate,?,?,?,0,?)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setString(1, d.getWriter());
			pstmt.setString(2, d.getTitle());
			pstmt.setString(3, d.getContent());
			pstmt.setString(4, d.getFname());
			pstmt.setInt(5, d.getType());
			
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

	public int update(Data d) {// id로 찾아서 pwd수정
		Connection conn = db.conn();
		String sql = "update dataroom set title=?, content=? where num=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getTitle());
			pstmt.setString(2, d.getContent());
			pstmt.setInt(3, d.getNum());
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
	
	public int updateCnt(int num) {// id로 찾아서 pwd수정
		Connection conn = db.conn();
		String sql = "update dataroom set cnt=cnt+1 where num=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();//처리된 줄 수 반환
			System.out.println(cnt + "번 글의 cnt 1증가");
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
	
	public int delete(int num) {
		Connection conn = db.conn();
		String sql = "delete from dataroom where num=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	public Data select(int num) {
		Connection conn = db.conn();
		String sql = "select * from dataroom where num=?";
		Data data = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//select는 executeQuery()로 실행
			//executeQuery()는 select를 실행하고 검색 결과를 ResultSet에 담아서 반환
			ResultSet rs = pstmt.executeQuery();
			//rs.next(): 읽을 다음 줄로 이동. 읽을 것이 있으면 true, 없으면 false반환
			if (rs.next()) {
				return new Data(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7),rs.getInt(8));
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
		return data;
	}
	
	public ArrayList<Data> selectAll(){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from dataroom order by num desc";
		
		//ArrayList 생성
		ArrayList<Data> list = new ArrayList<Data>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while (rs.next()) {
				list.add(new Data(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
	public ArrayList<Data> selectByCnt(){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from dataroom order by cnt desc";
		
		//ArrayList 생성
		ArrayList<Data> list = new ArrayList<Data>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while (rs.next()) {
				list.add(new Data(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
	public ArrayList<Data> selectByFcnt(){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from dataroom order by fcnt desc";
		
		//ArrayList 생성
		ArrayList<Data> list = new ArrayList<Data>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while (rs.next()) {
				list.add(new Data(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
	
	public ArrayList<Data> selectByType(int type){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from dataroom where type = ? order by num desc";
		
		//ArrayList 생성
		ArrayList<Data> list = new ArrayList<Data>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while (rs.next()) {
				list.add(new Data(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
