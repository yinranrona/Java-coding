<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除エラー</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<form action="emp-list-servlet" method="POST"><br>
		従業員削除エラー<br>
		<!-- ToDo エラーの原因を明示しましょう -->
		<input type="submit" value="従業員情報一覧表示画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html>