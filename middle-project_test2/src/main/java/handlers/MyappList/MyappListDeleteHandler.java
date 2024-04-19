package handlers.MyappList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.MyappListService;

public class MyappListDeleteHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		int num=Integer.parseInt(request.getParameter("num"));
		MyappListService service=new MyappListService();
		service.delete(num);
		view="redirect:"+view;
		
		return view;
	}

}
