<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <%
	Account acc = (Account)request.getAttribute("acc");
%> --%>
<table border="1">
	<tr>
		<%-- <td>계좌번호</td><td><%=acc.getId() %></td> --%>
		<td>계좌번호</td><td>${acc.id }</td>
	</tr>
	<tr>
		<%-- <td>이름</td><td><%=acc.getName() %></td> --%>
		<td>이름</td><td>${acc.name }</td>
	</tr>
	<tr>
		<%-- <td>잔액</td><td><%=acc.getBalance() %></td> --%>
		<td>잔액</td><td>${acc.balance }</td>
	</tr>
	<tr>
		<%-- <td>계좌구분</td><td><%=acc.getSect() %></td> --%>
		<td>계좌구분</td><td>${acc.sect }</td>
	</tr>
<%-- <%		if (acc.getSect().equals("special")) {
%>
	<tr>
		<td>등급</td><td><%=acc.getGrade() %></td>
		<td>등급</td><td>${acc.id }</td>
	</tr>
<% 		} %> --%>
	<c:if test="{acc.sect=='special'}">
		<tr><td>등급</td><td>${acc.grade}</td></tr>
	</c:if>
</table>