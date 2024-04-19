package handlers.dataroom;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dataroom.Data;
import dataroom.DataService;
import handlers.Handler;

public class DataroomAddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String view = "/index.jsp";
		if (request.getMethod().equals("POST")) {
		int size = 100 * 1024 * 1024;
		MultipartRequest multipart;
		try {
			multipart = new MultipartRequest(request, DataService.path, size, "utf-8",
					new DefaultFileRenamePolicy());

			String writer = multipart.getParameter("writer");
			String title = multipart.getParameter("title");
			String content = multipart.getParameter("content");
			int type = Integer.parseInt(multipart.getParameter("type"));
			System.out.println(writer);
			System.out.println(title);
			System.out.println(content);
			File f = multipart.getFile("fname");//업로드된 파일의 파일 객체 반환
			String fname= null;
			if(f!=null) {
				fname = f.getName();//업로드된 파일명
			}
			DataService dservice = new DataService();
			dservice.addData(new Data(0,writer,null,title,content,fname,0,type));
			view = "redirect:/dataroom/list.do";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			request.setAttribute("view", "/dataroom/add.jsp");
		}
		return view;
	}

}
