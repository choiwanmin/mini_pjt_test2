package handlers.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.Comment;
import comment.CommentService;
import handlers.Handler;
import mem.MemService;

public class CommentAddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if (request.getMethod().equals("POST")) {
			HttpSession session = request.getSession();
			int data_num = Integer.parseInt(request.getParameter("num"));
			String id = (String) session.getAttribute("loginId");
			String content = request.getParameter("comment");
			
			CommentService service = new CommentService();
			service.addComment(new Comment(id,content,data_num));
			view="redirect:/dataroom/detail.do?num="+data_num+"&id="+id;
			
		}
		return view;
	}

}
