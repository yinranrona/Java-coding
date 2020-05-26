<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録処理結果</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<%
		int count = (Integer) request.getAttribute("count");
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
	従業員コード：<jsp:getProperty property="employeeCode" name="emp"/><br>
	氏：<jsp:getProperty property="lastName" name="emp"/><br>
	名：<jsp:getProperty property="firstName" name="emp"/><br>
	氏カナ：<jsp:getProperty property="lastKanaName" name="emp"/><br>
	名カナ：<jsp:getProperty property="firstKanaName" name="emp"/><br>
	性別：<jsp:getProperty property="gender" name="emp"/><br>
	誕生日：<jsp:getProperty property="birthDay" name="emp"/><br>
	部署コード：<jsp:getProperty property="sectionCode" name="emp"/><br>
	入社日：<jsp:getProperty property="hireDate" name="emp"/><br>
	更新日：<jsp:getProperty property="updateDatetime" name="emp"/><br>

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html>