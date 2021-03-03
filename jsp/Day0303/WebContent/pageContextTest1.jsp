<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%
request.setAttribute("addr", "seoul");
pageContext.forward("pageContextTest2.jsp");%> --%>

<jsp:forward page="pageContextTest2.jsp">
	<jsp:param value="seoul" name="addr"/>
</jsp:forward>