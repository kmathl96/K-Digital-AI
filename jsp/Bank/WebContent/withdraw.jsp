<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Account" %>
<%
	String id = request.getParameter("id");
	int money = Integer.parseInt(request.getParameter("money"));
	Account acc = (Account)session.getAttribute(id);
	if (acc==null) {
		pageContext.forward("template.jsp?pasge=accsearch_fail");
	} else {
		boolean success = acc.withdraw(money);
		if (success) {
			pageContext.forward("template.jsp?page=withdraw_success");
		} else {
			pageContext.forward("template.jsp?page=withdraw_fail");
		}
	}
%>