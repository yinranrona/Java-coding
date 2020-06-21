<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除処理結果</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<br>
	<%
		int count = (Integer) request.getAttribute("count");
		if (count != 0) {
	%>
		以下の従業員情報を削除しました。<br>
	<%
		} else {
	%>
		以下の従業員情報を削除できませんでした。<br>
	<%
		}
	%>

	<!-- ToDo 削除した結果を表示します -->

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html>