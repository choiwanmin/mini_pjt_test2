package handlers.MyappList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.MyappList;
import person.MyappListService;

public class MyappListAddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		int id=Integer.parseInt(request.getParameter("userid"));
		String wanted_auth_no=request.getParameter("wanted_auth_no");
		String wanted_title=request.getParameter("wanted_title");
		
		MyappListService service=new MyappListService();
		service.add(new MyappList(0,id,wanted_auth_no,wanted_title,0));
		view = "redirect:"+view;
		
		return view;
	}

}
