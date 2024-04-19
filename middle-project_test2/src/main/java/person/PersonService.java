package person;

import java.util.ArrayList;

public class PersonService {
	private PersonDao dao;
	
	
	public PersonService() {
		
		dao = new PersonDao();
	}
	
	// 지원자(추가)
		public void addPerson(Person p) {
			dao.insert(p);
		}
		
	// 지원자 수정(업데이트)
		public void editPerson(Person p) {
			dao.update(p);
		}
		
	//지원자 삭제
		public void delPerson(String userid) {
			dao.delete(userid);
		}
	
	// 지원자 목록
		public ArrayList<Person> getAll(){
			return dao.selectAll();
		}
		
	//userid로 지원자 검색
		public Person getPerson(String userid) {
			return dao.select(userid);
		}
	
}
