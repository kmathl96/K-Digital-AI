<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String pagefile=request.getParameter("page");
	if(pagefile==null) {
		pagefile="newitem";
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Template Test</title>
<style>
	#table {
		margin: 20px auto;
		width:960px; height:500px;
		color:gray;
		/* border:1px solid gray; */
	}
	#table #top {
		background-color: #b5818f;
		height:43px;
		text-align : right;
		padding-right: 10px;
	}
	#table #left {
		background-color: silver;
		width : 15%;
		align : center;
		valign : top;
	}
	#table #right {
		background-color: #bcab8f;
		margin: 0 auto;		
	}
	#table #bottom {
		background-color: #8ea201;
		width : 100%;
		height : 43px; 
	}		
	
</style>
</head>
<body>
<table id="table">
	<tr><td id="top" colspan="3" ><jsp:include page="top.jsp"/></td></tr>
	<tr>
		<td id="left"><br>
			<jsp:include page="left.jsp"/></td>
		<td id="right" colspan="2" align="center" valign="top">
			<jsp:include page='<%=pagefile+".jsp"%>'/></td>
	</tr>
	<tr>
		<td id="bottom" colspan="3">
			<jsp:include page="bottom.jsp"/></td>
	</tr>
</table>
</body>
</html>