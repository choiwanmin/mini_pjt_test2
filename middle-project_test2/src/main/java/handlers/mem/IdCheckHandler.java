package handlers.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import handlers.Handler;
import mem.Mem;
import mem.MemService;

public class IdCheckHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		MemService service = new MemService();
		Mem m = service.getMem(id);
		boolean flag = false;
		if(m == null) {
			flag = true;
		}
		JSONObject obj = new JSONObject();
		obj.put("flag", flag);
		String res = obj.toJSONString();
		return "responsebody/" + res;
	}
}
