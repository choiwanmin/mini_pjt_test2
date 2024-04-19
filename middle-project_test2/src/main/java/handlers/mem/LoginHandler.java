package handlers.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handlers.Handler;
import mem.Mem;
import mem.MemService;

public class LoginHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if(request.getMethod().equals("POST")) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");

			MemService service = new MemService();
			Mem m = service.getMem(id);
			String msg = "";
			if (m == null) {
				msg = "없는 아이디";
			} else {
				if (pwd.equals(m.getPwd())) {
					msg = "로그인 성공";
					HttpSession session = request.getSession();// 현재 사용중인 세션을 반환. 
					//request.getSession(): param은 boolean값. true:현재 세션이 없으면 새로생성해서 줌. false:없으면 에러
					session.setAttribute("loginId", id);
					String type = "기업";
					if (m.getType() == 1) {
						type = "구직자";
					}
					session.setAttribute("loginType", type);
				} else {
					msg = "비번 오류";
				}
			}
			request.setAttribute("msg", msg);
		}else {
			request.setAttribute("view", "/mem/login.jsp");
		}
		return view;
	}

}
