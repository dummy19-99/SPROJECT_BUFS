package myProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		String 돌아갈페이지 = request.getParameter("rpage1");
	    String 상품명       = request.getParameter("pname1");
	    String 가격         = request.getParameter("price1");
	    
        PrintWriter out = new PrintWriter( response.getWriter() );
        out.println("<H1>Login</H1>");
		
        String 출력할내용 = "<FORM action='login.process' method='POST'>";
        출력할내용 += "<input type='hidden' name='rpage1' value="+돌아갈페이지+">";
        출력할내용 += "<input type='hidden' name='pname1' value="+상품명+">";
        출력할내용 += "<input type='hidden' name='price1' value="+가격+">";
        출력할내용 += "ID  <input type='text'     name='id1'><BR>";
        출력할내용 += "PWD <input type='password' name='pwd1'><BR>";
        출력할내용 += "	<input type='submit'>";
        출력할내용 += "</FORM>";
        
        out.println(출력할내용);
        
	}
	
	
}
