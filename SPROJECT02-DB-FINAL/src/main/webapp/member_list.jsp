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

<H1>Member 관리</H1>
<H3>수정하시려면 id를 클릭해주세요</H3>

<%
	String  SQL = "SELECT  *  FROM  member";	
	ResultSet rs = st.executeQuery( SQL );
	
	out.println("<table border=1>");
	out.println("<tr> <td><b>ID</td>  <td><b>PASSWORD</td> <td><b>NAME</td>  <td><b>TEL☎</td> <td><b>Etc.</td> </tr>");
	while( rs.next() ) {
		out.println("<TR>");
		String id1     = rs.getString("id1");
		String pass1   = rs.getString("pass1");
		String name1   = rs.getString("name1");
		String phone1  = rs.getString("phone1");
		out.println("<TD><a href=update.jsp?id1=" + id1 + ">" + id1 + "</a></TD>");
		out.println("<TD>" + pass1 + "</TD>");
		out.println("<TD>" + name1 + "</TD>");
		out.println("<TD>" + phone1 + "</TD>");
		String 삭제링크 = "<A  href='delete.jsp?id1="+id1+"'>삭제</A>";
		out.println("<TD>"+삭제링크+"</TD>");
		out.println("</TR>");		
	}
	out.println("</table>");

%>

<P><A href="index.jsp">main으로 돌아가기</A>


</body>
</html>