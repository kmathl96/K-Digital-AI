<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
public int sum() {
	int total = 0;
	for (int i=0; i<=100; i++) {
		total += i;
	}
	return total;
}
private int age;
%>
<% String str = "1~100까지의 합 : "; %>
</head>
<body>
<h2><%=str %><b><%=sum() %></b>입니다.</h2>
</body>
</html>