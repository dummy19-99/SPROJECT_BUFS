<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Class.forName("com.mysql.cj.jdbc.Driver"); // mysql8 부터.. 
String url = "jdbc:mysql://localhost:3306/" + "member_db"; 
String opt = "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"; // mysql8부터 추가 : "useSSL=false&serverTimezone=UTC" 
url += opt;

Connection   con = DriverManager.getConnection(url, "root", "woo991020*");
Statement    st  = con.createStatement();
%>

<%
    String  id1 = request.getParameter("id1");
    String  SQL = "SELECT * FROM member  WHERE id1 = '" + id1 + "'";    
    //out.println(SQL);
        	
	ResultSet rs = st.executeQuery( SQL );
	
	out.println("<FORM action='update_process.jsp'  method='POST'>");	
	while( rs.next() ) {	
		String id11    = rs.getString("id1");
		String pass1   = rs.getString("pass1");
		String name1   = rs.getString("name1");
		String phone1  = rs.getString("phone1");
		
		out.println("ID : " + id11 + "<BR>");
		out.println("<INPUT type='hidden' name='id1' value='"+id11+"'>");
		out.println("PASS : <INPUT type='password' name='pass1' value='"+pass1+"'><BR>");
		out.println("NAME : <INPUT type='text' name='name1' value='"+name1+"'><BR>");
		out.println("PHONE: <INPUT type='text' name='phone1' value='"+phone1+"'><BR>");
				
	}
	out.println("<input type='submit'>");
	out.println("</form>");
%>

</body>
</html>