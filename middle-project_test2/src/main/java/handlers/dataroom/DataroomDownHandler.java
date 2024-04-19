package handlers.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataroom.DataService;
import handlers.Handler;

public class DataroomDownHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = "C:\\down\\";
		String fname = request.getParameter("fname");
		File f = new File(path + fname);
		FileInputStream fi;
		try {
			fi = new FileInputStream(path + fname);
			fname = new String(fname.getBytes("utf-8"));
			// 첨부파일 보내도록 response 헤더를 설정
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fname);
			
			//response에 파일 내용을 출력
			OutputStream os = response.getOutputStream();
			int len;
			byte[] b = new byte[(int) f.length()];
			
			while((len=fi.read(b))>0) {
				os.write(b, 0, len);
			}
			
			os.flush();
			
			os.close();
			fi.close();
			
			int num = Integer.parseInt(request.getParameter("num"));
			DataService service = new DataService();
			service.editCnt(num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
