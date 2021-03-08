<%@page import="com.bean.BoardBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#articleForm {
	width: 500px;
	height: 500px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	height: 40px;
	text-align: center;
}

#articleContentArea {
	background: orange;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제 목 : ${article.BOARD_SUBJECT }
			첨부파일 :
			<c:if test="${article.BOARD_FILE==null }">
				<a href="file_down?downFile=${article.BOARD_FILE}"> ${article.BOARD_FILE} </a>
			</c:if>
	</section>
	<section id="articleContentArea">
		${article.BOARD_CONTENT }
	</section>
	</section>
	<section id="commandList">
		<a
			href="boardReplyForm?board_num=${article.BOARD_NUM}&page=${page}">
			[답변] </a> <a
			href="boardModifyForm?board_num=${article.BOARD_NUM}">
			[수정] </a> <a
			href="boardDeleteForm?board_num=${article.BOARD_NUM}&page=${page}">
			[삭제] </a> <a href="./boardListPro?page=${page}">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>