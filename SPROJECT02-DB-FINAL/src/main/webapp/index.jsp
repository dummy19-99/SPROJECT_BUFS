<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<H1>관리자 종합 페이지</H1>

<%
    String  adminId  = (String)session.getAttribute("adminId");
    String  adminPwd = (String)session.getAttribute("adminPwd");
    
    if(adminId == null || adminPwd == null) {
    	out.println("<A href=\"admin_login_form.html\">Admin login</A><BR>");
    	out.println("<font size=2>* 회원관리는 관리자 계정으로 로그인이 필요합니다</font><P>");    	
    } else if(adminId.equals("admin") && adminPwd.equals("1234")) {
    	out.println("<B style=color:red;background-color:yellow><a href=admin_logout.jsp>admin logout</a></B><P>");    	
    } else {
    	// 최고관리자가 비밀번호가 틀렸을 때 세션에 정보를 기록하는 경우는 없다고 하자...
    	out.println("<A href=\"admin_login_form.html\">Admin login</A><BR>");
    	out.println("<font size=2>* 회원관리는 관리자 계정으로 로그인이 필요합니다</font><P>");    	
    }
%>



<A href="register.html">회원가입</A><BR>
<A href="member_list.jsp">회원관리</A><BR>
<A href="product_list.jsp">상품등록관리</A><BR>





</body>
</html>