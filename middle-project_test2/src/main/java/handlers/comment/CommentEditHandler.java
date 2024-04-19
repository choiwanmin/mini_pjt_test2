package handlers.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.Comment;
import comment.CommentService;
import handlers.Handler;

public class CommentEditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
		int data_num = Integer.parseInt(request.getParameter("data_num"));
		CommentService cservice = new CommentService();
		int num = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("edit_content");
		cservice.editComment(new Comment(num,id,content,data_num));
		
		view="redirect:/dataroom/detail.do?num="+data_num+"&id="+id;
		return view;
	}

}
