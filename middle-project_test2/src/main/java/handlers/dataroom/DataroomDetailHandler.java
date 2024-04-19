package handlers.dataroom;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.Comment;
import comment.CommentService;
import dataroom.Data;
import dataroom.DataService;
import fav.FavoData;
import fav.FavoDataService;
import handlers.Handler;

public class DataroomDetailHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		DataService service = new DataService();
		service.editCnt(num);
		Data d = service.getData(num);
		FavoDataService fservice = new FavoDataService();
		FavoData fd = fservice.getFavoData(num, id);
		int fcnt = fservice.getFcnt(num);
		d.setFcnt(fcnt);
		CommentService cservice = new CommentService();
		ArrayList<Comment> list = cservice.getByDataNum(num);
		System.out.println(list);
		
		boolean flag = true;
		if(fd==null) {
			flag = false;
		}
		request.setAttribute("d", d);
		request.setAttribute("flag", flag);
		request.setAttribute("list", list);
		

		request.setAttribute("view", "/dataroom/detail.jsp");
		return view;
	}

}
