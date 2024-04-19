package appform;

public class AppForm {
	private int num;
	private int userid;
	private String coverletter;
	private String pofol;
	private String picture;

	public AppForm() {
	}

	public AppForm(int num, int userid, String coverletter, String pofol, String picture) {
		super();
		this.num = num;
		this.userid = userid;
		this.coverletter = coverletter;
		this.pofol = pofol;
		this.picture = picture;
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

	public String getCoverletter() {
		return coverletter;
	}

	public void setCoverletter(String coverletter) {
		this.coverletter = coverletter;
	}

	public String getPofol() {
		return pofol;
	}

	public void setPofol(String pofol) {
		this.pofol = pofol;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "AppForm [num=" + num + ", userid=" + userid + ", coverletter=" + coverletter + ", pofol=" + pofol
				+ ", picture=" + picture + "]";
	}

}
