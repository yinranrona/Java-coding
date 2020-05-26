<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報登録</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h3>従業員情報登録</h3>
	<form action="emp-input-result-servlet" method="POST"><br>
	氏　　　　：<input type="text" name="last-name"><br>
	名　　　　：<input type="text" name="first-name"><br>
	氏かな　　：<input type="text" name="last-kana-name"><br>
	名かな　　：<input type="text" name="first-kana-name"><br>
	性別　　　：<input type="text" name="gender">　※できればラジオボタンにしましょう<br>
	生年月日　：<input type="text" name="birth-day">　※できればカレンダーにしましょう<br>
	部署コード：<input type="text" name="section-code"><br>
	入社日　　：<input type="text" name="hire-date">　※できればカレンダーにしましょう<br>
		<input type="submit" value="従業員情報登録">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>