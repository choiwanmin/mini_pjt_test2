package handlers.corp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import corp.corp.Corp;
import corp.corp.CorpService;
import handlers.Handler;


public class CorpHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		//get=처음에 회사 정보 등록 페이지로 이동
		String view = "/index.jsp";

		//post=처음 회사 정보 등록(db에 추가)
		if(request.getMethod().equals("POST")) {
			String corpid = (String)request.getSession().getAttribute("loginId");
			String corp_nm = request.getParameter("corp_nm");
			//우편번호 + 주소 +상세주소
			String corp_addr = request.getParameter("p_code")+" "+request.getParameter("addr")+" "+request.getParameter("addrdet");
			String busi_no=request.getParameter("busi_no");
			
			//System.out.println("corpid: "+corpid+" /corp_nm: "+corp_nm+" /corp_addr: "+corp_addr+" /busi_no: "+busi_no);
			
			CorpService service = new CorpService();
			service.addCorp(new Corp(0,corpid,corp_nm,corp_addr,busi_no));
			
			view = "/index.jsp";
		}else {
			request.setAttribute("view", "/corp/add.jsp");
		}
		return view;
	}

}
