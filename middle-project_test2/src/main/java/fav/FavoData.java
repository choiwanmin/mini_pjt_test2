package fav;

public class FavoData {
	private int num;
	private int datanum;
	private String id;
	
	public FavoData() {
		
	}
	
	public FavoData(int num, int datanum, String id) {
		this.num = num;
		this.datanum = datanum;
		this.id = id;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDatanum() {
		return datanum;
	}
	public void setDatanum(int datanum) {
		this.datanum = datanum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "FavoData [num=" + num + ", datanum=" + datanum + ", id=" + id + "]";
	}
	
	
}
