package recruit.recruitdetail;

public class RecruitDetailService {
	private RecruitDetailDao dao;

	public RecruitDetailService() {
		dao = new RecruitDetailDao();
	}

	public void addRecruitDetail(RecruitDetail rd) {
		dao.insert(rd);
	}

	public RecruitDetail getByWantedAuthNo(String wantedAuthNo) {
		return dao.selectByWantedAuthNo(wantedAuthNo);
	}
}
