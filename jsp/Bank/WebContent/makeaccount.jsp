<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="acc" class="com.bean.Account"/>
<jsp:setProperty name="acc" property="*"/>
<%
	String id = acc.getId();
	Object obj = session.getAttribute(id);
	if (obj==null) {
		session.setAttribute(id, acc);
	%>
		<jsp:forward page="template.jsp?page=makeaccount_success"/>
<%	} else { %>
		<jsp:forward page="template.jsp?page=makeaccount_fail"/>
<%	} %>