<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	ArrayList<Account> accs = (ArrayList<Account>)request.getAttribute("accs");
%> --%>
<h3>[ 전체 계좌 조회 ]</h3>
<%-- <table border="1">
	<tr><td>계좌번호</td><td>이름</td><td>잔액</td><td>계좌구분</td><td>등급</td></tr>
<%	for (Account acc : accs) { %>
	<tr>
		<td><%=acc.getId() %></td>
		<td><%=acc.getName() %></td>
		<td><%=acc.getBalance() %></td>
		<td><%=acc.getSect() %></td>
<% 		if (acc.getSect().equals("special")) { %>
			<td><%=acc.getGrade() %></td>
<%		} else { %>
			<td></td>
<%		} %>
	</tr>
<%	} %>
</table> --%>
<table border="1">
	<tr><td>계좌번호</td><td>이름</td><td>잔액</td><td>계좌구분</td><td>등급</td></tr>
	<c:forEach var="acc" items="${accs }">
		<tr>
			<td>${acc.id }</td>
			<td>${acc.name }</td>
			<td>${acc.balance }</td>
			<td>${acc.sect }</td>
			<c:choose>
				<c:when test='${acc.sect=="special" }'>
					<td>${acc.grade }</td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>