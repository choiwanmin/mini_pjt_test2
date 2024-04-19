package handlers.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handlers.Handler;
import mem.MemService;

public class MemOutHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemService service = new MemService();
		System.out.println(request.getParameter("id"));
		service.delMem(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "/index.jsp";
	}

}
