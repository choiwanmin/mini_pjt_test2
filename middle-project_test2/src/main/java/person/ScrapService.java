package person;

import java.util.ArrayList;

public class ScrapService {

	private ScrapDao dao;
	public ScrapService() {
		dao=new ScrapDao();
	}
	
	public void add(Scrap s) {
		ArrayList<Scrap> arr=dao.selectById(s.getUserid());
		if(arr.size()>=10) {
			dao.delete(arr.get(0).getNum());
		}	
		dao.insert(s);
	}
	public void delete(int num) {
		dao.delete(num);
	}
	
	public Scrap getByNum(int num) {
		return dao.selectBynum(num);
	}
	public ArrayList<Scrap> getById(int id){
		return dao.selectById(id);
	}
}
