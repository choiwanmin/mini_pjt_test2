package person;

public class MyappList {

	private int num;
	private int userId;
	private String wanted_auth_no;
	private String wanted_title;
	private int recruit_status;
	
	public MyappList() {}
	
	
	
	
	public MyappList(int num, int userId, String wanted_auth_no, String wanted_title, int recruit_status) {
		super();
		this.num = num;
		this.userId = userId;
		this.wanted_auth_no = wanted_auth_no;
		this.wanted_title = wanted_title;
		this.recruit_status = recruit_status;
	}




	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWanted_auth_no() {
		return wanted_auth_no;
	}
	public void setWanted_auth_no(String wanted_auth_no) {
		this.wanted_auth_no = wanted_auth_no;
	}
	public String getWanted_title() {
		return wanted_title;
	}
	public void setWanted_title(String wanted_title) {
		this.wanted_title = wanted_title;
	}
	public int getRecruit_status() {
		return recruit_status;
	}
	public void setRecruit_status(int recruit_status) {
		this.recruit_status = recruit_status;
	}
	@Override
	public String toString() {
		return "MyappList [num=" + num + ", wanted_auth_no=" + wanted_auth_no + ", wanted_title=" + wanted_title
				+ ", recruit_status=" + recruit_status + "]";
	}
	
	
}
