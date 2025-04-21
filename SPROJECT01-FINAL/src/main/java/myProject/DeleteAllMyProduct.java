package myProject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteAllMyProduct extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		HttpSession session = request.getSession();  // JSP의 session(세션 )
		
	    // 세션에 저장된 상품리스트를 얻어와서
	    ArrayList  plist    = new ArrayList();
	    
	    // 상품리스트를 세션변수에 재등록
	    session.setAttribute("plist", plist);
	    
	    // 돌아가기...
	    response.sendRedirect("my.product.list");
	
	}

}
