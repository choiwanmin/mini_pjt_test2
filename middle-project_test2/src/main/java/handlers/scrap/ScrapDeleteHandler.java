package handlers.scrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.ScrapService;

public class ScrapDeleteHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		int num=Integer.parseInt(request.getParameter("num"));
		ScrapService service =new ScrapService();
		service.delete(num);
		view="redirect:"+view;
		return view;
	}

}
