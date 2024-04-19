package fav;

import java.util.ArrayList;


public class FavoDataService {
	private FavoDataDao dao;

	public FavoDataService() {
		dao = new FavoDataDao();
	}

	public void addFavoData(FavoData d) {
		dao.insert(d);
	}

	
	public void delFavoData(FavoData d) {
		dao.delete(d);
	}

	public int getFcnt(int datanum) {
		return dao.selectFcnt(datanum);
	}
	
	public ArrayList<String> getIds(int datanum){
		return dao.selectIds(datanum);
	}
	
	public FavoData getFavoData(int datanum, String id) {
		return dao.select(datanum, id);
	}
}
