package myProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddProduct extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html; charset=UTF-8");
		   response.setCharacterEncoding("UTF-8");		   		   
		   request.setCharacterEncoding("UTF-8");
		   
		   HttpSession session = request.getSession();  // JSP의 session(세션 )
		   PrintWriter out     = new PrintWriter(response.getWriter());				   
		   String 상품명       = request.getParameter("pname1");		   
		   ArrayList plist     = (ArrayList) session.getAttribute("plist");
		   
		   if(plist == null) {
			   plist = new ArrayList();
		   }
		   
		   if(plist.indexOf(상품명) == -1) {
			   plist.add(상품명);
			   session.setAttribute("plist", plist);   
			   out.println("<script>alert('상품을 장바구니에 담았습니다. 첫 페이지로 돌아갑니다.');location.href=\"index\";</script>");	   
		   } else {
			   out.println("<script>alert('같은 상품이 이미 담겨있습니다. 첫 페이지로 돌아갑니다.');location.href=\"index\";</script>");	   
		   }   

		
	}

}
