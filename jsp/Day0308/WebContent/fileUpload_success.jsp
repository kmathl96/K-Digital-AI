<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
올린 사람 : ${name }<br>
제목 : ${subject }<br>

파일명1 : <a href="fileDownLoad?file_name=${filename1 }">${origfilename1 }</a><br>
파일명2 : <a href="fileDownLoad?file_name=${filename2 }">${origfilename2 }</a>
</body>
</html>