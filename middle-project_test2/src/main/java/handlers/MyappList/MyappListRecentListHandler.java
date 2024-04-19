package handlers.MyappList;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handlers.Handler;
import person.MyappList;

public class MyappListRecentListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/test1.jsp";
		HttpSession session = request.getSession(false);
		String num = request.getParameter("num");
		String dnum=request.getParameter("dnum");
		String title = request.getParameter("title");
		ArrayList<MyappList> list = (ArrayList<MyappList>) session.getAttribute("recent");
		if(list==null) {
			list=new ArrayList<MyappList>();
		}
		for(MyappList m:list) {
			if(m.getWanted_auth_no().equals(num))
				return "redirect:"+view;
		}
		if(num !=null) {
			if (list.size() >= 5) {
				list.remove(0);
			}
			list.add(new MyappList(0, 0, num, title, 0));
		}
		if(dnum != null) {
			for(MyappList m :list) {
				if(m.getWanted_auth_no().equals(dnum)) {
					list.remove(m);
					break;
				}
			}
		}
		session.setAttribute("recent", list);
		session.setAttribute("view", "/myapplist/recent.jsp");
		return "redirect:"+view;
	}

}
