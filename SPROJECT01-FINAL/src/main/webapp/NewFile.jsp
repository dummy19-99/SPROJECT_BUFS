<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	Class.forName("com.mysql.cj.jdbc.Driver"); // mysql8 부터.. 
	String url = "jdbc:mysql://localhost:3306/" + "test1"; 
	String opt = "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"; // mysql8부터 추가 : "useSSL=false&serverTimezone=UTC" 
	url += opt;
	
	Connection   con = DriverManager.getConnection(url, "root", "1234");
	Statement    st  = con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from table1");
	
	while( rs.next() ) {
		String t1 = rs.getString("t1");
		String t2 = rs.getString("t2");
		
		out.println("t1 = " + t1 + "<BR>");
		out.println("t2 = " + t2 + "<BR>");
		out.println("-------------<BR>");
	}


%>

</body>
</html>