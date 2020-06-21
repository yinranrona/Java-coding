<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録エラー</title>
</head>
<body>
	<%@ include file="header.jsp" %>

		<h3>従業員登録エラー</h3>
		<!-- ToDo エラーの原因を明示しましょう -->
	 	<c:if test="${modeForward == 1}">
			未入力エラー
			<jsp:forward page="emp-input.jsp" />
		</c:if>
		<c:if test="${modeForward == 2}">
			従業員コードの形式エラー
			<jsp:forward page="emp-input.jsp" />
		</c:if>
		<c:if test="${modeForward == 3}">
			 部署コードの形式エラー
		</c:if>
		<c:if test="${modeForward == 4}">
			全角かなエラー
		</c:if>
		<c:if test="${modeForward == 5}">
			入社日の形式エラー
		</c:if>
		<c:if test="${modeForward == 6}">
			認証エラー：従業員コードも存在しました。<br>
		</c:if> 

		<c:if test="${modeForward != 0}">
			<jsp:forward page="emp-input.jsp" />
		</c:if>
		
	<form action="emp-input-servlet" method="POST">
		<input type="submit" value="従業員情報登録画面">
	</form>

	<%@ include file="footer.jsp" %>

</body>
</html> --%>