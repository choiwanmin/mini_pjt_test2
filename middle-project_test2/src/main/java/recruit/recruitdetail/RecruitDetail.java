package recruit.recruitdetail;

import java.sql.Date;

// 공고상세
public class RecruitDetail {
	private int num; // 공고저장순서
	private String wantedAuthNo; // 공고-공고번호(recruit_list테이블-wanted_auth_no컬럼)
	private int minSal; // 공고-최소임금금액
	private int maxSal; // 공고-최대임금금액
	private String relJobNm; // 공고-관련직종
	private String srchKeyWordNm; // 공고-키워드
	private String jobCont; // 공고-공고상세
	private Date smodifyDtm; // 공고-최종수정일
	private String basicAddr; // 공고-근무지 기본주소
	private String detailAddr; // 공고-근무지 상세주소
	private String contactTelNo; // 공고-공고 담당 전화번호
	private int recruitCheck;
	private int type; // 공고상태(ex.진행, 마감, 삭제)

	public RecruitDetail() {

	}

	public RecruitDetail(int num, String wantedAuthNo, int minSal, int maxSal, String relJobNm, String srchKeyWordNm,
			String jobCont, Date smodifyDtm, String basicAddr, String detailAddr, String contactTelNo, int recruitCheck,
			int type) {
		super();
		this.num = num;
		this.wantedAuthNo = wantedAuthNo;
		this.minSal = minSal;
		this.maxSal = maxSal;
		this.relJobNm = relJobNm;
		this.srchKeyWordNm = srchKeyWordNm;
		this.jobCont = jobCont;
		this.smodifyDtm = smodifyDtm;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
		this.contactTelNo = contactTelNo;
		this.recruitCheck = recruitCheck;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecruitDetail [num=" + num + ", wantedAuthNo=" + wantedAuthNo + ", minSal=" + minSal + ", maxSal="
				+ maxSal + ", relJobNm=" + relJobNm + ", srchKeyWordNm=" + srchKeyWordNm + ", jobCont=" + jobCont
				+ ", smodifyDtm=" + smodifyDtm + ", basicAddr=" + basicAddr + ", detailAddr=" + detailAddr
				+ ", contactTelNo=" + contactTelNo + ", recruitCheck=" + recruitCheck + ", type=" + type + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWantedAuthNo() {
		return wantedAuthNo;
	}

	public void setWantedAuthNo(String wantedAuthNo) {
		this.wantedAuthNo = wantedAuthNo;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}

	public String getRelJobNm() {
		return relJobNm;
	}

	public void setRelJobNm(String relJobNm) {
		this.relJobNm = relJobNm;
	}

	public String getSrchKeyWordNm() {
		return srchKeyWordNm;
	}

	public void setSrchKeyWordNm(String srchKeyWordNm) {
		this.srchKeyWordNm = srchKeyWordNm;
	}

	public String getJobCont() {
		return jobCont;
	}

	public void setJobCont(String jobCont) {
		this.jobCont = jobCont;
	}

	public Date getSmodifyDtm() {
		return smodifyDtm;
	}

	public void setSmodifyDtm(Date smodifyDtm) {
		this.smodifyDtm = smodifyDtm;
	}

	public String getBasicAddr() {
		return basicAddr;
	}

	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getContactTelNo() {
		return contactTelNo;
	}

	public void setContactTelNo(String contactTelNo) {
		this.contactTelNo = contactTelNo;
	}

	public int getRecruitCheck() {
		return recruitCheck;
	}

	public void setRecruitCheck(int recruitCheck) {
		this.recruitCheck = recruitCheck;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
