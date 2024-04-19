package person;

public class Scrap {
	private int num;
	private int userid;
	private String wanted_auth_no;
	
	
	public Scrap() {}
	
	@Override
	public String toString() {
		return "Scrap [num=" + num + ", userid=" + userid + ", wanted_auth_no=" + wanted_auth_no + "]";
	}
	public Scrap(int num, int userid, String wanted_auth_no) {
		super();
		this.num = num;
		this.userid = userid;
		this.wanted_auth_no = wanted_auth_no;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getWanted_auth_no() {
		return wanted_auth_no;
	}
	public void setWanted_auth_no(String wanted_auth_no) {
		this.wanted_auth_no = wanted_auth_no;
	}
	
	
	
}
