package handlers.scrap;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.Scrap;
import person.ScrapService;

public class ScrapListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view="";
		int id=Integer.parseInt(request.getParameter("userid"));
		ScrapService service =new ScrapService();
		ArrayList<Scrap> list=service.getById(id);
		request.setAttribute("list", list);
		return view;
	}

}
