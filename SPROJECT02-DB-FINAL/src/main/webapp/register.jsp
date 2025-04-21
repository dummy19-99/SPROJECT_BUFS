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
Statement   st      = con.createStatement();
%>

<%   
   //response.setContentType("text/html; charset=UTF-8");
   request.setCharacterEncoding("UTF-8");

   String  id1    = request.getParameter("id1");
   String  pass1  = request.getParameter("pass1");
   String  name1  = request.getParameter("name1");
   String  phone1 = request.getParameter("phone1");   
   
   // PPT : page 7의 내용...
   String SQL = "INSERT INTO member VALUE('"+id1+"', '"+pass1+"', '"+name1+"', '"+phone1+"')";
   st.executeUpdate( SQL );

   response.sendRedirect("index.jsp");

%>









</body>
</html>