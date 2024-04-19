package handlers.dataroom;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataroom.Data;
import dataroom.DataService;
import handlers.Handler;

public class DataroomListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		DataService service = new DataService();
		ArrayList<Data> list = null;
		
		int viewtype = Integer.parseInt(request.getParameter("viewtype"));
		
		if(viewtype==1) {
			list = service.getAll();
		}else if(viewtype==2) {
			list = service.getByCnt();
		}
		request.setAttribute("viewtype", viewtype);
		request.setAttribute("list", list);
		request.setAttribute("view", "/dataroom/list.jsp");
		return view;
	}

}
