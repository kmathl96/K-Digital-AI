<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String id = request.getParameter("id"); // 파라미터 값은 input의 name값
	String pass = request.getParameter("pass");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디는 <%=id %>입니다.<br>
	비밀번호는 <%=pass %>입니다.
</body>
</html>