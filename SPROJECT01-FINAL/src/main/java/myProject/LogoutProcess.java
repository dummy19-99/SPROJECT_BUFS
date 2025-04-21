package myProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutProcess extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession   session      = request.getSession();  // JSP의 session(세션 )
		String        돌아갈페이지 = request.getParameter("rpage1");

	    // 세션변수 
	    String isOK = "";
	    session.setAttribute("isOK", isOK);
	    
	    // new login...
	    session.setAttribute("loginId", "");
	    session.setAttribute("loginPwd", "");
	    
	    response.sendRedirect(돌아갈페이지);
	}

}
