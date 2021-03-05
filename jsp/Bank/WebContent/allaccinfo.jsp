<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Account> accs = new ArrayList<>();
	Enumeration<String> it = session.getAttributeNames();
	while (it.hasMoreElements()) {
		String name = it.nextElement();
		Object obj = session.getAttribute(name);
		if (obj instanceof Account) {
			Account acc = (Account) obj;
			accs.add(acc);
		}
	}
	if (accs.size()>0) {
		request.setAttribute("accs", accs);
		pageContext.forward("template.jsp?page=allaccinfo_success");
	} else {
		pageContext.forward("template.jsp?page=allaccinfo_fail");
	}
%>