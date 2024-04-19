package comment;

import java.util.ArrayList;


public class CommentService {
	private CommentDao dao;

	public CommentService() {
		dao = new CommentDao();
	}

	// 회원가입(추가)
	public void addComment(Comment c) {
		dao.insert(c);
	}

	public Comment getComment(int num) {
		return dao.select(num);
	}
	
	// pwd수정
	public void editComment(Comment c) {
		dao.update(c);
	}

	// 탈퇴
	public void delComment(int num) {
		dao.delete(num);
	}

	// 회원목록
	public ArrayList<Comment> getByDataNum(int data_num) {
		return dao.selectByDataNum(data_num);
	}
	
}
