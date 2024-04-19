package handlers.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import mem.Mem;
import mem.MemService;

public class MemAddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp"; // get 방식일때 이동할 뷰페이지경로
		if (request.getMethod().equals("POST")) {// 전송방식이 post냐?

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			int type = Integer.parseInt(request.getParameter("type"));// "1"

			MemService service = new MemService();
			service.addMem(new Mem(id, pwd, type));
			
			view = "redirect:/index.jsp";
		}else {
			request.setAttribute("view", "/mem/join.jsp");
		}

		return view;
	}

}