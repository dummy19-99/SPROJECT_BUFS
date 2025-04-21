package myProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyProductList extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		PrintWriter  out     = new PrintWriter( response.getWriter() );
		HttpSession  session = request.getSession();
				
		out.println("<H1> 장바구니 보기</H1>");
		
		    ArrayList  plist = (ArrayList) session.getAttribute("plist");

		    if(plist == null) {
		    	out.println("장바구니에 담겨있는 물품이 없습니다..");
		    } else {
		    	out.println("<table border=1><tr><th>NO</th><th>상품</th><th>비고</th></tr>");
		    	for(int k=0; k<plist.size(); k++) {
		    		String 삭제폼 = "<form action='delete.my.product' method='get'>";
		    		삭제폼 += "<input type='hidden' name='pid1' value='"+k+"'>";
		    		삭제폼 += "<input type='submit' value='삭제'></form>";
		   		    
		    		out.println("<tr>");
		    		out.println("<td>"+(k+1)+"</td><td>"+plist.get(k)+"</td> <td>"+삭제폼+"</td>");
		    		out.println("</tr>");
		    	}
		    	out.println("</table border=1>");
		    }
		    
		    out.println("<P><A href='delete.all.my.product'>장바구니 비우기</A>");
		    out.println("<P><A href='index'>메인으로 돌아가기</A>");
		
		
	}

}
