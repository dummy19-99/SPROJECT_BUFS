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

<%!

boolean 최고관리자확인(String adminId, String adminPwd) {
	
	if(adminId.equals("admin") && adminPwd.equals("1234")) { 
		return true;
	} else { 
		return false;
	}
}


%>

<%
Class.forName("com.mysql.cj.jdbc.Driver"); // mysql8 부터.. 
String url = "jdbc:mysql://localhost:3306/" + "member_db"; 
String opt = "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"; // mysql8부터 추가 : "useSSL=false&serverTimezone=UTC" 
url += opt;
Connection   con = DriverManager.getConnection(url, "root", "woo991020*");
Statement   st      = con.createStatement();
%>

<%
     String adminId  = (String)session.getAttribute("adminId");
	 String adminPwd = (String)session.getAttribute("adminPwd");
	
	 adminId  = (adminId  == null)? "" : adminId;
	 adminPwd = (adminPwd == null)? "" : adminPwd;
	
	 if(!최고관리자확인(adminId, adminPwd)) {
		out.println("<script>alert('최고 관리자로 로그인이 필요합니다.');</script>");
		out.println("<p><a href='member_list.jsp'>리스트로 가기</a>");
		return;		    	
	 } 
	 
     request.setCharacterEncoding("UTF-8");

     String  id1    = request.getParameter("id1");
     String  pass1  = request.getParameter("pass1");
     String  name1  = request.getParameter("name1");
     String  phone1 = request.getParameter("phone1");

     // PPT : page 7의 내용...
     // UPDATE member  SET  pass1='4321', name1='지니황'  WHERE id1='hwang';
     String SQL = "UPDATE member SET pass1='"+pass1+"', name1='";
     SQL += name1+"', phone1='"+phone1+"' WHERE id1='"+id1+"'";
     
     st.executeUpdate( SQL );

     response.sendRedirect("member_list.jsp");

%>

</body>
</html>