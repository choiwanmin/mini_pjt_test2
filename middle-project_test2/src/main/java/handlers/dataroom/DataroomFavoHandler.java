package handlers.dataroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fav.FavoData;
import fav.FavoDataService;
import handlers.Handler;

public class DataroomFavoHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		FavoDataService service = new FavoDataService();
		if(type.equals("1")) {
			service.addFavoData(new FavoData(0,num,id));
		}else {
			service.delFavoData(new FavoData(0,num,id));
		}
		view="redirect:/dataroom/detail.do?num="+num+"&id="+id;
		return view;
	}

}
