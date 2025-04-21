package myProject;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Index extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    
		HttpSession session = request.getSession();  // JSP의 session(세션 )
		PrintWriter out     = new PrintWriter(response.getWriter());
		
		out.println("<H1>구팡(Goupang)에 오신 것을 환영합니다</H1>");
		
		String  loginId   = (String)session.getAttribute("loginId");
		String  loginPwd  = (String)session.getAttribute("loginPwd");
		
		if( ! DB클래스.DB로그인(loginId, loginPwd) ) {
		  	out.println("<A href='login.form?rpage1=index'>로그인<A> 회원가입<p>");
		} else {
		  	String 로그아웃버튼  =   " <form action='logout.process'  method='GET'> ";
		   	로그아웃버튼         +=  " <input type='hidden' name='rpage1' value='index'> ";
		   	로그아웃버튼         +=  loginId + " <br><input type='submit' value='로그아웃'></form> ";
		    	
		  	out.println(로그아웃버튼 + " <P>");
		}
	
		
		out.println("<img src=\"pic1.png\" width=\"200\">");

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql8 부터.. 
			String url = "jdbc:mysql://localhost:3306/" + "product_db"; 
			String opt = "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"; // mysql8부터 추가 : "useSSL=false&serverTimezone=UTC" 
			url += opt;
			
			Connection   con = DriverManager.getConnection(url, "root", "woo991020*");
			Statement    st  = con.createStatement();
			
			String  SQL = "SELECT  *  FROM  product";	
			ResultSet rs = st.executeQuery( SQL );
			
			out.println("<table border=1>");
			out.println("<tr> <td><b>P_Code</td>  <td><b>P_Name</td> <td><b>Price</td>  <td><b>brand</td> <td><b>Etc.</td> </tr>");
			while( rs.next() ) {
				out.println("<TR>");
				String pcode1     = rs.getString("pcode");
				String pname1   = rs.getString("pname");
				String pprice1   = rs.getString("pprice");
				String pmaker1  = rs.getString("pmaker");
				out.println("<TD>" + pcode1 + "</TD>");
				out.println("<TD>" + pname1 + "</TD>");
				out.println("<TD>" + pprice1 + "</TD>");
				out.println("<TD>" + pmaker1 + "</TD>");
				out.println("<TD></TD>");
				out.println("</TR>");
				
				// 삭제
				/*
				String 삭제링크 = "<A  href='delete.jsp?id1="+pcode1+"'>삭제</A>";
				out.println("<TD>"+삭제링크+"</TD>");
				out.println("</TR>");	
				*/	
			}
			out.println("</table>");
			
		} catch (Exception 예외) {
			
		}
		
		/*
		out.println("<table border=1>");
		out.println("<tr><th>NO</th><th>상품명</th><th>가격(만원)</th> <th>비고</th> </tr>");
		out.println("<tr><td>1</td> <td><a href=\"product.detail?pname1=TV&price1=120\">TV</a>   </td> <td>120 </td> <td> </td> </tr>");
		out.println("<tr><td>2</td> <td><a href=\"product.detail?pname1=radio&price1=4\">라디오</a> </td> <td>4   </td> <td> </td> </tr>");
		out.println("<tr><td>3</td> <td><a href=\"product.detail?pname1=computer&price1=170\">컴퓨터</a> </td> <td>170 </td> <td> </td> </tr>");
		out.println("</table>");

		out.println("<h2><a href=\"my.product.list\">장바구니 보기</a></h2>");
		*/
		
	
	}
	
	

}

