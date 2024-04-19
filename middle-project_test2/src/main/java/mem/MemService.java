package mem;

import java.util.ArrayList;
import java.util.Scanner;

//service
public class MemService {
	private MemDao dao;
	public static String loginId;

	public MemService() {
		dao = new MemDao();
	}

	// 회원가입(추가)
	public void addMem(Mem m) {
		dao.insert(m);
	}

	public Mem getMem(String id) {
		return dao.select(id);
	}
	
	// pwd수정
	public void editMem(Mem m) {
		dao.update(m);
	}

	// 탈퇴
	public void delMem(String id) {
		dao.delete(id);
	}

	// 회원목록
	public ArrayList<Mem> getAll() {
		return dao.selectAll();
	}
	
}
