package recruitApply;

import java.sql.Date;
//공고 지원자 리스트
public class RecruitApply {
	private String wanted_auth_no;//공고 번호-공고 번호(wanted_auth_no)
	private String wanted_title;//공고 제목
	private String applycant_num;//지원자-person(num)
	private Date appldate;//지원일
	private String busi_no;//사업자 번호
	
	
	public RecruitApply() {}
	
	
	public RecruitApply(String wanted_auth_no, String wanted_title, String applycant_num, Date appldate, String busi_no) {
		super();
		this.wanted_auth_no = wanted_auth_no;
		this.wanted_title = wanted_title;
		this.applycant_num = applycant_num;
		this.appldate = appldate;
		this.busi_no = busi_no;
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


	public String getApplycant_num() {
		return applycant_num;
	}


	public void setApplycant_num(String applycant_num) {
		this.applycant_num = applycant_num;
	}


	public Date getAppldate() {
		return appldate;
	}


	public void setAppldate(Date appldate) {
		this.appldate = appldate;
	}


	public String getBusi_no() {
		return busi_no;
	}


	public void setBusi_no(String busi_no) {
		this.busi_no = busi_no;
	}


	@Override
	public String toString() {
		return "RecruitApply [wanted_auth_no=" + wanted_auth_no + ", wanted_title=" + wanted_title + ", applycant_num="
				+ applycant_num + ", appldate=" + appldate + ", busi_no=" + busi_no + "]";
	}

	
}
