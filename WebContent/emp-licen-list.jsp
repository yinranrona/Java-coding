<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.ListEmp"%>
<%@ page import="model.entity.EmpBean"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報一覧</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body>

<form action="emp-delete-servlet" method="POST">
	<div class="div1">
		<%@ include file="header.jsp"%>

		<div id="divpagecontent" style="width:90%">
			<table style="width:90%">
				<tr>
					<td style="width:20%">
					<table style="margin-top: 30px">
							<tr>
								<td class="listtitle">操作</td>
							</tr>
							<tr>
								<td class="listtd"><img src="img/miniicon2.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="emp-list-servlet?infoModify=1">従業員情報変更</a></td>
							</tr>
							<tr>
								<td class="listtd"><img src="img/miniicon2.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="empLicen-list-servlet?infoModify=1">保有資格情報変更</a></td>
							</tr>
							<c:if test="${authority2.equals(authority2)}">
							<tr>
								<td class="listtd">&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">総務部限定</font></td>
							</tr>
							</c:if>
							<tr>
								<td class="listtd"><img src="img/miniicon2.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="logout.html">ログアウト</a>
								</td>
							</tr>
						</table>
						</td>
						
						<td>
						<div style="text-align: right">
							<a href="menu.jsp">メニュー画面</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;ようこそ
						</div>
						<table class="infocontent">
							<tr>
								<c:if test="${infoModify==1}">
									<th><input type="submit" name="submit" value="削除" /></th>
								</c:if>
								<th style="width:20%">従業員コード</th>
								<th style="width:20%">保有資格</th>
								<th style="width:20%">資格取得日</th>
								<c:if test="${infoModify==1}">
									<th></th>
								</c:if>
							</tr>
							<c:forEach items="${requestScope.emplicenbeanlist}" var="emplicenbean">
								<jsp:useBean id="emplicenbean" scope="request" class="model.entity.EmpLicenBean" />
								<tr>
									<c:if test="${infoModify==1}">
										<td><input type="checkbox" name="check" value="<jsp:getProperty property="employeeCode" name="emplicenbean"/>"/></td>
									</c:if>
									<td><jsp:getProperty property="employeeCode" name="emplicenbean" /></td>
									<td><jsp:getProperty property="licenseName" name="emplicenbean" /></td>
									<td><jsp:getProperty property="licenseDate" name="emplicenbean" /></td>
									<c:if test="${infoModify==1}">
									<td><input type="submit" name="submit" value="編集"/></td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						</td>
				</tr>
			</table>
		</div>

		<div class="pagination">
			<ul>
				<li class="nextPage"><a
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=${pageInfo.getCurrentPage()==1?1:pageInfo.getCurrentPage()-1}&infoModify=1">&lt;&lt;前ページ</a>
				</li>
				<li class="miPage"><font size="5px">${pageInfo.getCurrentPage()}</font>ページ/<font
					size="5px">${pageInfo.getTotalPage()}</font>ページ</li>
				<li class="nextPage"><a
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=${pageInfo.getCurrentPage()==pageInfo.getTotalPage()?pageInfo.getTotalPage():pageInfo.getCurrentPage()+1}&infoModify=1">&gt;&gt;後ページ</a>
				</li>
			</ul>
		</div>

		<!-- ToDo 従業員情報を一覧表示してください -->
		<!-- ToDo 従業員を1名選択し、従業員情報編集画面に移行してください -->
		<!-- ToDo 従業員を1名選択し、従業員情報削除画面に移行してください -->

		<%-- <form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面">
	</form>
	<%@ include file="footer.jsp" %> --%>
	</div>
	</form>
</body>
</html>