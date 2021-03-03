<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>[ 계좌개설 ]</h2>
	<form action="#" id="createAccount" method="POST">
		<table>
			<tr>
				<td><label for="accNo">계좌번호</label></td>
				<td><input type="text" id="accNo"></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td>
				<td><input type="text" id="name"></td>
			</tr>
			<tr>
				<td><label for="balance">입금액</label></td>
				<td><input type="text" id="balance"></td>
			</tr>
			<tr>
				<td><label for="account">계좌구분</label></td>
				<td>
					<div>
						<input type="radio" name="radio" value="normal" checked="checked">일반&nbsp;
						<input type="radio" name="radio" value="speacial">특수
					</div>
				</td>
			</tr>
			<tr>
				<td><label for="grade">등급</label></td>
				<td>
					<select disabled="disabled">
						<option value="V">VIP</option>
						<option value="G">Gold</option>
						<option value="S">Silver</option>
						<option value="N">Normal</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="개설"></td>
			</tr>
		</table>
	</form>
</body>
</html>