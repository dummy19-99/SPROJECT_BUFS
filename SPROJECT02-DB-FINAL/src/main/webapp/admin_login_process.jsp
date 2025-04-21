<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    String   adminId  = request.getParameter("adminId");
    String   adminPwd = request.getParameter("adminPwd");
    
    if(adminId.equals("admin") && adminPwd.equals("1234")) {
    	session.setAttribute("adminId", adminId);
    	session.setAttribute("adminPwd", adminPwd);
    }
    response.sendRedirect("index.jsp");
%>

</body>
</html>