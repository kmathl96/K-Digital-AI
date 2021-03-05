<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Account" %>
<%
	String id = request.getParameter("id");
	Account acc = (Account)session.getAttribute(id);
	if (acc==null) {
		pageContext.forward("template.jsp?page=accsearch_fail");
	} else {
		request.setAttribute("acc",acc);
		pageContext.forward("template.jsp?page=accinfo_success");
	}
%>