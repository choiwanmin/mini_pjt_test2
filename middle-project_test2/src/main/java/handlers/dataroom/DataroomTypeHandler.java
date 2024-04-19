package handlers.dataroom;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataroom.Data;
import dataroom.DataService;
import handlers.Handler;

public class DataroomTypeHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		DataService service = new DataService();
		String typename = request.getParameter("type");
		int type = 0;
		if(typename.equals("신입")) {
			type = 1;
		}else if(typename.equals("취준")){
			type = 2;
		}else if(typename.equals("채용공고")){
			type = 3;
		}
		else if(typename.equals("자소서")){
			type = 4;
		}
		else if(typename.equals("면접")){
			type = 5;
		}
		
		ArrayList<Data> list = service.getByType(type);
		
		request.setAttribute("list", list);
		request.setAttribute("view", "/dataroom/list.jsp");
		return view;
	}

}
