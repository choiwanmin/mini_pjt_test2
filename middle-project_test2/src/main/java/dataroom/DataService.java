package dataroom;

import java.util.ArrayList;


public class DataService {
	private DataDao dao;
	//자료실 경로
	public static String path = "C:\\down\\";

	public DataService() {
		dao = new DataDao();
	}

	// 회원가입(추가)
	public void addData(Data d) {
		dao.insert(d);
	}

	public Data getData(int num) {
		return dao.select(num);
	}
	
	// pwd수정
	public void editData(Data d) {
		dao.update(d);
	}

	// 탈퇴
	public void delData(int num) {
		dao.delete(num);
	}

	// 회원목록
	public ArrayList<Data> getAll() {
		return dao.selectAll();
	}
	// 회원목록
		public ArrayList<Data> getByCnt() {
			return dao.selectByCnt();
		}
	// 회원목록
	public ArrayList<Data> getByType(int type) {
		return dao.selectByType(type);
	}
	public void editCnt(int num) {
		dao.updateCnt(num);
	}
}
