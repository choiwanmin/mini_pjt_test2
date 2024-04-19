package handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Handler {
	//웹 요청 처리 메서드. 이동할 페이지 경로 반환
	String process(HttpServletRequest request, HttpServletResponse response);
}

