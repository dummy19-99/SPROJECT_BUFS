package myProject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteMyProduct extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		HttpSession  session = request.getSession(); ///////////////////////////
	    ArrayList    plist   = (ArrayList) session.getAttribute("plist");	    
	    String       pid1    = request.getParameter("pid1");
	
	    //out.println("삭제하라고 지정해온 pid1 = " + pid1);
	    plist.remove( Integer.parseInt( pid1 ) );
	    
	    //out.println("해당 상품을 삭제했습니다..");
	    response.sendRedirect("my.product.list");   ////////////////////////////
    

	}

}
