<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%pageContext.include("pageContextTest3.jsp"); %> --%>
<jsp:include page="pageContextTest3.jsp">
	<jsp:param value="010-1111-2222" name="tel"/>
</jsp:include>
<h2>pageContext의 forward 메소드로 포워딩된 페이지입니다.</h2>
<h2><%=request.getParameter("param") %></h2>
<h2><%=request.getParameter("addr") %></h2>
</body>
</html>