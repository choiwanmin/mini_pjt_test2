package recruit.recruitlist;

public class RecruitListService {
	private RecruitListDao dao;

	public RecruitListService() {
		dao = new RecruitListDao();
	}

	public void addRecruitList(RecruitList rl) {
		dao.insert(rl);
	}

	public RecruitList getByWantedAuthNo(String busiNo, String wantedAuthNo) {
		return dao.selectByWantedAuthNo(busiNo, wantedAuthNo);
	}
}
