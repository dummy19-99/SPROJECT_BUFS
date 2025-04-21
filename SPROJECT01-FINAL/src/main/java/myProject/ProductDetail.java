package myProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductDetail extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		HttpSession session = request.getSession();  // JSP의 session(세션 )
		PrintWriter out     = new PrintWriter(response.getWriter());

	    String 상품명       = request.getParameter("pname1");
	    String 가격         = request.getParameter("price1");
	   
	    out.println("<H1>상품명 : "+상품명+"</H1>");
	    out.println("<H3>가격 : "+가격+"</H3>");
	
	
	
	     String  isOK = (String)session.getAttribute("isOK");
	     
	     String loginId = (String)session.getAttribute("loginId");
	     String loginPwd = (String)session.getAttribute("loginPwd");
	     
	     
	     if(loginId == null ||  !DB클래스.DB로그인(loginId, loginPwd)) {
	    	out.println("로그인이 필요한 서비스가 있습니다. 로그인하려면 다음을 클리해주세요.<P>");
	    	out.println("<A href='login.form?rpage1=product.detail&pname1="+상품명+"&price1="+가격+"'>로그인</A>");    	
	    	return;
	     }


		out.println("<FORM action=\"add.product\"  method=\"POST\">");
		out.println("<input type=\"hidden\" name=\"pname1\" value=\""+상품명+"\">");
		out.println("<input type=\"submit\" value=\"장바구니담기\">");
		out.println("</FORM>");



	}

}
