<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	if (id!=null) {
		session.setAttribute("id", id);
	}
	pageContext.forward("template.jsp?page=makeaccount_form");
%>