package appform;

import java.util.ArrayList;

import person.Person;
import person.PersonDao;

public class AppFormService {
private AppFormDao dao;
	
	
	public AppFormService() {
		
		dao = new AppFormDao();
	}
	
	// 지원자(추가)
		public void addForm(AppForm f) {
			dao.insert(f);
		}
		
	// 지원자 수정(업데이트)
		public void editForm(AppForm f) {
			dao.update(f);
		}
		
	//지원자 삭제
		public void delForm(int userid) {
			dao.delete(userid);
		}
	
	// 지원자 목록
		public ArrayList<AppForm> getAll(){
			return dao.selectAll();
		}
		
	//userid로 지원자 검색 , userid  int값 
		public AppForm getForm(int userid) {
			return dao.select(userid);
		}
}
