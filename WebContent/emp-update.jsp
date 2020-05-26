<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員編集画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h3>従業員編集画面</h3>
	<form action="emp-update-result-servlet" method="POST"><br>
	<!-- ToDo 選択した従業員データを編集するような画面を作成してください -->
	※編集項目<br>
		<input type="submit" value="従業員情報編集">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>