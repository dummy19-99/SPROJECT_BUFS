<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<H1>������ ���� ������</H1>

<%
    String  adminId  = (String)session.getAttribute("adminId");
    String  adminPwd = (String)session.getAttribute("adminPwd");
    
    if(adminId == null || adminPwd == null) {
    	out.println("<A href=\"admin_login_form.html\">Admin login</A><BR>");
    	out.println("<font size=2>* ȸ�������� ������ �������� �α����� �ʿ��մϴ�</font><P>");    	
    } else if(adminId.equals("admin") && adminPwd.equals("1234")) {
    	out.println("<B style=color:red;background-color:yellow><a href=admin_logout.jsp>admin logout</a></B><P>");    	
    } else {
    	// �ְ�����ڰ� ��й�ȣ�� Ʋ���� �� ���ǿ� ������ ����ϴ� ���� ���ٰ� ����...
    	out.println("<A href=\"admin_login_form.html\">Admin login</A><BR>");
    	out.println("<font size=2>* ȸ�������� ������ �������� �α����� �ʿ��մϴ�</font><P>");    	
    }
%>



<A href="register.html">ȸ������</A><BR>
<A href="member_list.jsp">ȸ������</A><BR>
<A href="product_list.jsp">��ǰ��ϰ���</A><BR>





</body>
</html>