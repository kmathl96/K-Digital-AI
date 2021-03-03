<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="per" class="com.bean.Person"/>
<!-- setter로 접근 -->
<jsp:setProperty name="per" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- getter로 접근 -->
	<h3><jsp:getProperty property="name" name="per"/></h3>
	<h3><jsp:getProperty property="age" name="per"/></h3>
</body>
</html>