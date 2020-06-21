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
									href="empLicen-list-servlet">保有資格情報閲覧</a></td>
							</tr>
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
								<th>従業員コード</th>
								<th>氏</th>
								<th>名</th>
								<th>氏かな</th>
								<th>名かな</th>
								<th>性別</th>
								<th>生年月日</th>
								<th>部署コード</th>
								<th>入社日</th>
								<c:if test="${infoModify==1}">
									<th></th>
								</c:if>
							</tr>
							<c:forEach items="${requestScope.listEmp}" var="empbean">
								<jsp:useBean id="empbean" scope="session"
									class="model.entity.EmpBean" />
								<tr>
									<c:if test="${infoModify==1}">
										<td><input type="checkbox" name="check" value="<jsp:getProperty property="employeeCode" name="empbean"/>"/></td>
									</c:if>
									<td><jsp:getProperty property="employeeCode"
											name="empbean" /></td>
									<td><jsp:getProperty property="lastName" name="empbean" /></td>
									<td><jsp:getProperty property="firstName" name="empbean" /></td>
									<td><jsp:getProperty property="lastKanaName"
											name="empbean" /></td>
									<td><jsp:getProperty property="firstKanaName"
											name="empbean" /></td>
									<c:if test="${empbean.getGender()==0}">
										<td><c:out value="不明"/></td>
									</c:if>
									<c:if test="${empbean.getGender()==1}">
										<td><c:out value="男"/></td>
									</c:if>
									<c:if test="${empbean.getGender()==2}">
										<td><c:out value="女"/></td>
									</c:if> 
									<td><jsp:getProperty property="birthDay" name="empbean" /></td>
									<td><jsp:getProperty property="sectionCode" name="empbean" /></td>
									<td><jsp:getProperty property="hireDate" name="empbean" /></td>
									<c:if test="${infoModify==1}">
									<td><input type="submit" name="submit" value="編集"/></td>
									</c:if>
									<c:if test="${authority1.equals(authority1)}">
									<td><input type="submit" name="submit" value="資格登録"/></td>
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
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=1&infoModify=1">&lt;&lt;最初</a>
				</li>
				<li class="nextPage"><a
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=${pageInfo.getCurrentPage()==1?1:pageInfo.getCurrentPage()-1}&infoModify=1">&lt;&lt;前ページ</a>
				</li>
				<li class="miPage"><font size="5px">${pageInfo.getCurrentPage()}</font>ページ/<font
					size="5px">${pageInfo.getTotalPage()}</font>ページ</li>
				<li class="nextPage"><a
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=${pageInfo.getCurrentPage()==pageInfo.getTotalPage()?pageInfo.getTotalPage():pageInfo.getCurrentPage()+1}&infoModify=1">後ページ&gt;&gt;</a>
				</li>
				<li class="nextPage"><a
					href="${pageContext.request.contextPath}/emp-list-servlet?currentPage=${pageInfo.getTotalPage()}&infoModify=1">最後&gt;&gt;</a>
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