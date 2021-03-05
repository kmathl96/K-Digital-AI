<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="test" value="Hello JSTL!"/>
	<h3><c:out value="${test }"/></h3>
	
	<c:catch var="err">
	<%=10/0 %>
	</c:catch>
	<c:out value="${err }"></c:out>
	
	<c:if test="${5<10 }">
		<h3>5는 10보다 작습니다.</h3>
	</c:if>
	<c:if test="${3+6==9 }">
		<h3>3+6은 9입니다.</h3>
	</c:if>
	
	<c:choose>
		<c:when test="${5+10==50 }">
			<h3>5+10은 50이다.</h3>
		</c:when>
		<c:otherwise>
			<h3>5+10은 50이 아니다.</h3>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="test" begin="1" end="10" step="2">
		<b>${test }</b>
	</c:forEach>
	<c:forTokens var="data" items="홍길동,고길동,박길동" delims=",">
		<b>${data }</b>
	</c:forTokens>
	<c:set var="arr" value="apple#banana#orange"/>
	<c:forTokens var="data" items="${arr }" delims="#">
		<b>${data }</b>
	</c:forTokens>
</body>
</html>