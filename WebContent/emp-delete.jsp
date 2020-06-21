<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h3>従業員削除画面</h3>
	<form action="emp-delete-result-servlet" method="POST"><br>
	<!-- ToDo 選択した従業員データを削除する確認画面を作成してください -->
	※削除項目<br>
		<input type="submit" value="従業員情報削除">
	<!-- ToDo 可能ならばキャンセル可能にしてください -->
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>


