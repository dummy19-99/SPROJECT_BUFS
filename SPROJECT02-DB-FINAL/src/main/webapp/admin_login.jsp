<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Admin Log-In</h1>


<form action="admin_login_process.jsp" method="POST">
    Admin ID
    <input type="text" id="username" name="adminId"><br><br>

    Admin PW
    <input type="password" id="password" name="adminPwd"><br><br>

    <input type="submit" value="로그인">
</form>


<p><a href="register.html">회원가입</a></p>

<A href="index.jsp">back to MAIN.</A>


</body>
</html>