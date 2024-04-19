package person;

import java.util.ArrayList;

public class MyappListService {
	
	private MyappListDao dao;
	public MyappListService() {
		dao=new MyappListDao();
	}
	
	public void add(MyappList a) {
		dao.insert(a);
	}
	
	public void delete(int num) {
		dao.delete(num);
	}
	
	public MyappList getByNum(int num) {
		return dao.selectBynum(num);
	}
	public ArrayList<MyappList> getById(int id){
		return dao.selectById(id);
	}
}
