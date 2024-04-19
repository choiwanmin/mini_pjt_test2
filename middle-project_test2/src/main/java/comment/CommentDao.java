package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import dataroom.Data;

public class CommentDao {
	private DBConnect db;

	public CommentDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Comment c) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into comment_table values(seq_comment.nextval,?,?,?)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getContent());
			pstmt.setInt(3, c.getData_num());
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

	public int update(Comment c) {
		Connection conn = db.conn();
		String sql = "update comment_table set content=? where num=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getContent());
			pstmt.setInt(2, c.getNum());
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
	
	
	public int delete(int num) {
		Connection conn = db.conn();
		String sql = "delete from comment_table where num=?";
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
	public Comment select(int num) {
		Connection conn = db.conn();
		String sql = "select * from comment_table where num=?";

		//ArrayList 생성
		ArrayList<Comment> list = new ArrayList<Comment>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//select는 executeQuery()로 실행
			//executeQuery()는 select를 실행하고 검색 결과를 ResultSet에 담아서 반환
			ResultSet rs = pstmt.executeQuery();
			//rs.next(): 읽을 다음 줄로 이동. 읽을 것이 있으면 true, 없으면 false반환
			if (rs.next()) {
				return new Comment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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
	
	public ArrayList<Comment> selectByDataNum(int data_num){
		//db 연결
		Connection conn = db.conn();
		
		//sql문 작성
		String sql = "select * from comment_table where data_num = ? order by num ";
		
		//ArrayList 생성
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		try {
			//PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data_num);
			//sql 실행
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet 읽을 줄로 이동
			while (rs.next()) {
				list.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
