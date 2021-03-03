<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mem" class="com.bean.Member"/>
<jsp:setProperty name="mem" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 정보 확인 페이지</title>
<style>
	table { width: 400px; }
	h1 { text-align: center; }
</style>
</head>
<body>
	<table>
		<tr><td><b>아이디 : </b></td>
			<td><jsp:getProperty property="id" name="mem"/></td>
		</tr>
		<tr><td><b>비밀번호 : </b></td>
			<td><jsp:getProperty property="pass" name="mem"/></td>
		</tr>
		<tr><td><b>이름 : </b></td>
			<td><jsp:getProperty property="name" name="mem"/></td>
		</tr>
		<tr><td><b>성별 : </b></td>
			<td><jsp:getProperty property="sex" name="mem"/></td>
		</tr>
		<tr><td><b>나이 : </b></td>
			<td><jsp:getProperty property="age" name="mem"/></td>
		</tr>
		<tr><td><b>이메일주소 : </b></td>
			<td><jsp:getProperty property="email" name="mem"/></td>
		</tr>
	</table>
</body>
</html>