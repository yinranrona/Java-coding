<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録結果</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<%
		int count = (Integer)request.getAttribute("count");
		if (count != 0) {
	%>
		以下の従業員情報を登録しました。<br>
	<%
		} else {
	%>
		以下の従業員情報を登録できませんでした。<br>
	<%
		}
	%>

	<jsp:useBean id="emp" class="model.entity.EmpBean" scope="request"/>
		<!-- ToDo Beanからデータを取得して表示します -->

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html>