package recruit.recruitlist;

import java.sql.Date;

// 공고 목록
public class RecruitList {
	private String busiNo; // 기업-사업자등록번호(corp테이블-busi_no컬럼)
	private String wantedAuthNo; // 공고-공고번호
	private String wantedTitle; // 공고-공고제목
	private String salTpCd; // 공고-임금조건
	private String sal; // 공고-임금조건에 따른 임금
	private String minEdubgIcd; // 공고-최소학력
	private String enterTpCd; // 공고-경력
	private String workRegion; // 공고-근무지역 전체 주소
	private int regionCd; // 공고-근무지역코드(ex.경기도 성남시)
	private String jobsNm; // 공고-직종이름
	private int jobsCd; // 공고-직종코드
	private Date regDt; // 공고-등록일
	private Date closeDt; // 공고-마감일
	private int saveStatus; // 공고저장상태(ex.임시저장, 등록)
	private String homePg; // 기업-기업홈페이지주소
	private boolean type; // 공고등록(ex.api공고, 사용자공고)

	public RecruitList() {

	}

	public RecruitList(String busiNo, String wantedAuthNo, String wantedTitle, String salTpCd, String sal,
			String minEdubgIcd, String enterTpCd, String workRegion, int regionCd, String jobsNm, int jobsCd,
			Date regDt, Date closeDt, int saveStatus, String homePg, boolean type) {
		super();
		this.busiNo = busiNo;
		this.wantedAuthNo = wantedAuthNo;
		this.wantedTitle = wantedTitle;
		this.salTpCd = salTpCd;
		this.sal = sal;
		this.minEdubgIcd = minEdubgIcd;
		this.enterTpCd = enterTpCd;
		this.workRegion = workRegion;
		this.regionCd = regionCd;
		this.jobsNm = jobsNm;
		this.jobsCd = jobsCd;
		this.regDt = regDt;
		this.closeDt = closeDt;
		this.saveStatus = saveStatus;
		this.homePg = homePg;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecruitList [busiNo=" + busiNo + ", wantedAuthNo=" + wantedAuthNo + ", wantedTitle=" + wantedTitle
				+ ", salTpCd=" + salTpCd + ", sal=" + sal + ", minEdubgIcd=" + minEdubgIcd + ", enterTpCd=" + enterTpCd
				+ ", workRegion=" + workRegion + ", regionCd=" + regionCd + ", jobsNm=" + jobsNm + ", jobsCd=" + jobsCd
				+ ", regDt=" + regDt + ", closeDt=" + closeDt + ", saveStatus=" + saveStatus + ", homePg=" + homePg
				+ ", type=" + type + "]";
	}

	public String getBusiNo() {
		return busiNo;
	}

	public void setBusiNo(String busiNo) {
		this.busiNo = busiNo;
	}

	public String getWantedAuthNo() {
		return wantedAuthNo;
	}

	public void setWantedAuthNo(String wantedAuthNo) {
		this.wantedAuthNo = wantedAuthNo;
	}

	public String getWantedTitle() {
		return wantedTitle;
	}

	public void setWantedTitle(String wantedTitle) {
		this.wantedTitle = wantedTitle;
	}

	public String getSalTpCd() {
		return salTpCd;
	}

	public void setSalTpCd(String salTpCd) {
		this.salTpCd = salTpCd;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getMinEdubgIcd() {
		return minEdubgIcd;
	}

	public void setMinEdubgIcd(String minEdubgIcd) {
		this.minEdubgIcd = minEdubgIcd;
	}

	public String getEnterTpCd() {
		return enterTpCd;
	}

	public void setEnterTpCd(String enterTpCd) {
		this.enterTpCd = enterTpCd;
	}

	public String getWorkRegion() {
		return workRegion;
	}

	public void setWorkRegion(String workRegion) {
		this.workRegion = workRegion;
	}

	public int getRegionCd() {
		return regionCd;
	}

	public void setRegionCd(int regionCd) {
		this.regionCd = regionCd;
	}

	public String getJobsNm() {
		return jobsNm;
	}

	public void setJobsNm(String jobsNm) {
		this.jobsNm = jobsNm;
	}

	public int getJobsCd() {
		return jobsCd;
	}

	public void setJobsCd(int jobsCd) {
		this.jobsCd = jobsCd;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public Date getCloseDt() {
		return closeDt;
	}

	public void setCloseDt(Date closeDt) {
		this.closeDt = closeDt;
	}

	public int getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(int saveStatus) {
		this.saveStatus = saveStatus;
	}

	public String getHomePg() {
		return homePg;
	}

	public void setHomePg(String homePg) {
		this.homePg = homePg;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

}
