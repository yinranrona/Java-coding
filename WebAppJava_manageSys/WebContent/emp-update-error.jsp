<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員更新エラー</title>
</head>
<body>
	<%@ include file="header.jsp" %>

		従業員更新エラー
		<!-- ToDo エラーの原因を明示しましょう -->>

	<form action="emp-update-servlet" method="POST">
		<input type="submit" value="従業員情報更新画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html>