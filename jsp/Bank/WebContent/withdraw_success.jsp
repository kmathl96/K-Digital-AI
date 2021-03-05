<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String id = request.getParameter("id");
	String money = request.getParameter("money");
%>
<%=id %> 계좌에서 <%=money %>를 출금하였습니다. --%>
${param.id} 계좌에 ${param.money}원 출금하였습니다.