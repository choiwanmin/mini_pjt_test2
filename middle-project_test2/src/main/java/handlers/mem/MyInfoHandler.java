	package handlers.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handlers.Handler;
import mem.Mem;
import mem.MemService;
import person.Person;
import person.PersonService;

public class MyInfoHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
			
		String view = "/index.jsp";
		
		if(request.getMethod().equals("GET")) {//get 요청 id로 검색
			HttpSession session = request.getSession(false);
			// 로그인한 사람의 id를 session에서 꺼냄
			String loginId = (String) session.getAttribute("loginId");
			MemService service = new MemService();
			// loginId db에서 검색
			Mem m = service.getMem(loginId);
			PersonService pservice = new PersonService();
			Person p = pservice.getPerson(loginId);
			// 검색한 객체를 request에 담음. jsp에서 사용하려고
			request.setAttribute("m", m);
			request.setAttribute("p", p);
			request.setAttribute("view", "/mem/myinfo.jsp");
		}else {//post 요청 .수정
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			MemService service = new MemService();
			service.editMem(new Mem(id, pwd, 0));
			view = "redirect:/index.jsp";
		}
		return view;
	}

}
