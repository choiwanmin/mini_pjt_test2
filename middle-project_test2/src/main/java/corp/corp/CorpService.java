package corp.corp;

public class CorpService {
	private CorpDao dao;

	public CorpService() {
		dao = new CorpDao();
	}

	public int addSeq() {
		return dao.insertSeq();
	}

	public void addCorp(Corp c) {
		dao.insert(c, addSeq());
	}

//	public void addMemberCorp() {
//		dao.insertMember(addSeq());
//	}
//
//	public void addCorp(Corp c) {
//		dao.insert(c, addSeq());
//	}

	public Corp getByNum(int num) {
		return dao.select(num);
	}

	public Corp getByBusiNo(String busi_no) {
		return dao.selectByBusino(busi_no);
	}
}
