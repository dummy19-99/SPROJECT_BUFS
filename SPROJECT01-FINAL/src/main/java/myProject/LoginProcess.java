package myProject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class LoginProcess extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html; charset=UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   request.setCharacterEncoding("UTF-8");	    
		
		   String 돌아갈페이지  = request.getParameter("rpage1");
		   String 상품명      = request.getParameter("pname1");
		   String 가격       = request.getParameter("price1");
		   String id1       = request.getParameter("id1");
		   String pwd1      = request.getParameter("pwd1");
		   
           HttpSession   session  = request.getSession();  // JSP의 session(세션 )
           PrintWriter   out = new PrintWriter( response.getWriter() );
           
		   //if(id1.equals("hong") && pwd1.equals("1234") ) {
           if( DB클래스.DB로그인(id1, pwd1) ) {
        	   session.setAttribute("loginId", id1);
        	   session.setAttribute("loginPwd", pwd1);
        	   
			   response.sendRedirect(돌아갈페이지+"?pname1="+상품명+"&price1="+가격);
		   } else {
			   out.println("login 실패");
		   }
	}
	
}

