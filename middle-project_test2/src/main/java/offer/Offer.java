package offer;

import java.sql.Date;
//스카웃 제안
public class Offer {
	private int num;
	private int corp_id;//회사 정보-회사 정보(num)
	private String wanted_auth_no;//공고 번호-공고 번호(wanted_auth_no)
	private String userid;//개인 회원-person(num)
	private Date offerdate;//제안 날짜
	private int accept;//승락여부(제안 기본(미응답)-0,제안 승낙-1,제안 거부-2)
	
	public Offer() {}

	public Offer(int num, int corp_id, String wanted_auth_no, String userid, Date offerdate, int accept) {
		super();
		this.num = num;
		this.corp_id = corp_id;
		this.wanted_auth_no = wanted_auth_no;
		this.userid = userid;
		this.offerdate = offerdate;
		this.accept = accept;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCorp_id() {
		return corp_id;
	}

	public void setCorp_id(int corp_id) {
		this.corp_id = corp_id;
	}

	public String getWanted_auth_no() {
		return wanted_auth_no;
	}

	public void setWanted_auth_no(String wanted_auth_no) {
		this.wanted_auth_no = wanted_auth_no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getOfferdate() {
		return offerdate;
	}

	public void setOfferdate(Date offerdate) {
		this.offerdate = offerdate;
	}

	public int getAccept() {
		return accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}

	@Override
	public String toString() {
		return "Offer [num=" + num + ", corp_id=" + corp_id + ", wanted_auth_no=" + wanted_auth_no + ", userid="
				+ userid + ", offerdate=" + offerdate + ", accept=" + accept + "]";
	}
	
	
}
