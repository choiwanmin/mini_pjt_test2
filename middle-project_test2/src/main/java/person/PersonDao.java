package person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;

public class PersonDao {
	private DBConnect db;

	public PersonDao() {
		db = DBConnect.getInstance();
	}

	public void insert(Person p) {
		Connection conn = db.conn();
		// 실행할 쿼리문 작성
		String sql = "insert into person values(seq_person.nextval,?,?,?,?,?,?,?,?,?,?)";
		// 자바에서 sql을 실행할 수 있는 PreparedStatement 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// pstmt.set..(?순서, 값): ? 들어갈 값 설정
			pstmt.setString(1, p.getUserid());
			pstmt.setString(2, p.getUsertel());
			pstmt.setString(3, p.getEmail());
			pstmt.setString(4, p.getEducation());
			pstmt.setString(5, p.getCareer());
			pstmt.setString(6, p.getSkill());
			pstmt.setString(7, p.getGender());
			pstmt.setString(8, p.getAge());
			pstmt.setString(9, p.getJobCd());
			pstmt.setString(10, p.getJobNm());
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

	public int update(Person p) {// id로 찾아서 pwd수정
		Connection conn = db.conn();
		String sql = "update person set usertel=? , email=?, skill=?, jobCd=? where userid=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getUsertel());
			pstmt.setString(2, p.getEmail());
			pstmt.setString(3, p.getSkill());
			pstmt.setString(4, p.getJobCd());
			pstmt.setString(5, p.getUserid());
			cnt = pstmt.executeUpdate();// 처리된 줄 수 반환
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

	public int delete(String userid) {
		Connection conn = db.conn();
		String sql = "delete from person where userid=?";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
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

	// 유저정보 검색
	// id로 유저 정보 검색
	public Person select(String userid) {
		Connection conn = db.conn();
		String sql = "select * from person where userid=?";
		Person person = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			// select는 executeQuery()로 실행
			// executeQuery()는 select를 실행하고 검색 결과를 ResultSet에 담아서 반환
			ResultSet rs = pstmt.executeQuery();
			// rs.next(): 읽을 다음 줄로 이동. 읽을 것이 있으면 true, 없으면 false반환
			if (rs.next()) {
				person = new Person();
				person.setNum(rs.getInt(1));// 1번 컬럼의 문자열 값을 읽음
				person.setUserid(rs.getString(2));// 2번 컬럼의 문자열 값을 읽음
				person.setUsertel(rs.getString(3));// 3번 컬럼의 문자열 값을 읽음
				person.setEmail(rs.getString(4));// 4번 컬럼의 문자열 값을 읽음
				person.setEducation(rs.getString(5));
				person.setCareer(rs.getString(6));
				person.setSkill(rs.getString(7));
				person.setGender(rs.getString(8));
				person.setAge(rs.getString(9));
				person.setJobCd(rs.getString(10));
				person.setJobNm(rs.getString(11));
				// mem = new
				// Mem(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
				// rs.getInt(5));
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
		return person;
	}

	
	public ArrayList<Person> selectAll() {
		Connection conn = db.conn();
		String sql = "select * from person";
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			// PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// sql 실행
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setNum(rs.getInt(1));
				person.setUserid(rs.getString(2));
				person.setUsertel(rs.getString(3)); 
				person.setEmail(rs.getString(4));
				person.setEducation(rs.getString(5));
				person.setCareer(rs.getString(6));
				person.setSkill(rs.getString(7));
				person.setGender(rs.getString(8));
				person.setAge(rs.getString(9));
				person.setJobCd(rs.getString(10));
				list.add(person);
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
