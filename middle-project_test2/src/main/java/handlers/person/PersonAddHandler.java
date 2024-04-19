package handlers.person;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handlers.Handler;
import person.Person;
import person.PersonService;

public class PersonAddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String view = "/index.jsp"; // get 방식일때 이동할 뷰페이지경로
		String msg = "";
		if (request.getMethod().equals("POST")) {// 전송방식이 post냐?
			PersonService service = new PersonService();
			String userid = request.getParameter("userid");
			if(service.getPerson(userid) == null) {
				String jcd = "";
				String jNm = "";
				String usertel =request.getParameter("usertel");
				String email = request.getParameter("email");
				String education = request.getParameter("education");// "1"
				String career = request.getParameter("career");// "1"
				String skill = request.getParameter("skill");
				String gender = request.getParameter("gender");// "1"
				String age = request.getParameter("age");// "1"
				
				String[] jobCd =request.getParameterValues("jobCd");// "1"
				for(int i =0; i<jobCd.length; i++) {
						String []a=jobCd[i].split(",");
					   jcd+=a[0]+" , ";
					  jNm+=a[1]+" , ";
				}
				service.addPerson(new Person(0,userid,usertel,email,education,career,skill,gender,age,jcd,jNm));
			}else {
				System.out.println("이미 정보를 등록하셧습니다, 내정보보기에서 정보를 수정해주세요");
				msg = "이미 정보를 등록하셧습니다, 내정보보기에서 정보를 수정해주세요";
				request.setAttribute("msg", msg);
			}
			
		}else {
			request.setAttribute("view", "/person/personadd.jsp");
		}

		return view;
	}
	

}
