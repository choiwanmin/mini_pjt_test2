package handlers.MyappList;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.MyappList;
import person.MyappListService;

public class MyappListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		int id=Integer.parseInt(request.getParameter("userid"));
		MyappListService service=new MyappListService();
		ArrayList<MyappList> list=service.getById(id);
		request.setAttribute("list", list);
		
		return view;
	}

}
