<%@ page import="com.bean.PageInfo"%>
<%@ page import="com.bean.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MVC 게시판</title>
<style type="text/css">
h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 950px;
}

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 1000px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 950px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<h2>글 목록 <a href="boardWriteForm">게시판글쓰기</a></h2>
		
	<c:choose>
	<c:when test="${articleList!=null && pageInfo.listCount>0 }">
		<section id="listForm">
		<table>
			<tr id="tr_top">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			
			<c:forEach var="article" items="${articleList }">
				<tr>
				<td>${article.BOARD_NUM }</td>
				<td>
				<c:choose> 
					<c:when test="${article.BOARD_RE_LEV!=0}">
						<c:forEach var="i" begin="0" end="${article.BOARD_RE_LEV*2}">
							&nbsp;
						</c:forEach>
						▶
					</c:when>
					<c:otherwise>▶</c:otherwise>
				</c:choose>
				<a href="./boardDetailPro?board_num=${article.BOARD_NUM}&page=${pageInfo.page}">
					${article.BOARD_SUBJECT} 
				</a>
				</td>
				<td>${article.BOARD_NAME }</td>
				<td>${article.BOARD_DATE }</td>
				<td>${article.BOARD_READCOUNT }</td>
				</tr>
			</c:forEach>
		</table>
		</section>
		<section id="pageList">
			<c:choose>
				<c:when test="${pageInfo.page<=1}">
					[이전]&nbsp;
				</c:when>
				<c:otherwise>
					<a href="boardListPro?page=${pageInfo.page-1}">[이전]</a>&nbsp;
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
				<c:choose>
					<c:when test="${pageInfo.page==i }">[${i }]</c:when>
					<c:otherwise>
						<a href="boardListPro?page=${i}">[${i }]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pageInfo.page>=pageInfo.maxPage }">
					[다음]
				</c:when>
				<c:otherwise>
					<a href="boardListPro?page=${pageInfo.page+1}">[다음]</a>
				</c:otherwise>
			</c:choose>
		</section>
	</c:when>	
	<c:otherwise>
		<section id="emptyArea">등록된 글이 없습니다.</section>
	</c:otherwise>
	</c:choose>
</body>
</html>