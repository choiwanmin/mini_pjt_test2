package corp.corp;

// 회사 정보
public class Corp {
	private int num; // 회사저장순서
	private String corpid; // 회사 로그인 id
	private String corp_nm;// 회사 이름
	private String corp_addr;// 회사 주소
	private String busi_no;// 회사 사업자 등록번호

	public Corp() {
	}

	public Corp(int num, String corpid, String corp_nm, String corp_addr, String busi_no) {
		super();
		this.num = num;
		this.corpid = corpid;
		this.corp_nm = corp_nm;
		this.corp_addr = corp_addr;
		this.busi_no = busi_no;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getCorp_nm() {
		return corp_nm;
	}

	public void setCorp_nm(String corp_nm) {
		this.corp_nm = corp_nm;
	}

	public String getCorp_addr() {
		return corp_addr;
	}

	public void setCorp_addr(String corp_addr) {
		this.corp_addr = corp_addr;
	}

	public String getBusi_no() {
		return busi_no;
	}

	public void setBusi_no(String busi_no) {
		this.busi_no = busi_no;
	}

	@Override
	public String toString() {
		return "Corp [num=" + num + ", corpid=" + corpid + ", corp_nm=" + corp_nm + ", corp_addr=" + corp_addr
				+ ", busi_no=" + busi_no + "]";
	}

}