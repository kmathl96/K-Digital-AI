<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${id == null }">
		<a href="./login">Login</a>
	</c:when>
	<c:otherwise>
		<a href="./logout">Logout</a>
	</c:otherwise>
</c:choose>
<a href="./template.jsp?page=join_form">Join</a>