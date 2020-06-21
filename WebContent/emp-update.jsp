<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員編集画面</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp" %>
	<h3>従業員編集画面</h3>
	<br>
	<!-- ToDo 選択した従業員データを編集するような画面を作成してください -->

		<table class="infocontent">
			<tr>
				<td>
					<form action="emp-update-servlet" method="POST">
						<table style="width:180%; margin: 0 auto; class=upline">
					
						<jsp:useBean id="empBean" scope="request" class="model.entity.EmpBean"/>
						
							<tr>
								<td style="text-align: right; width: 20%">氏：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="lastname"  class="textinput" 
									value="<jsp:getProperty property="lastName" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">名：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="firstname"  class="textinput" 
									value="<jsp:getProperty property="firstName" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">氏かな：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="lastkananame"  class="textinput" 
									value="<jsp:getProperty property="lastKanaName"
											name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">名かな：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="firstkananame"  class="textinput" 
									value="<jsp:getProperty property="firstKanaName"
											name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">性別：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="gender"  class="textinput" 
									value="<jsp:getProperty property="gender" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">生年月日：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="birthday"  class="textinput" 
									value="<jsp:getProperty property="birthDay" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">部署コード：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="sectioncode"  class="textinput" 
									value="<jsp:getProperty property="sectionCode" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right; width: 20%">入社日：</td>
								<td style="width: 15%; padding-left: 20px">
									<input type="text" name="hiredate"  class="textinput" 
									value="<jsp:getProperty property="hireDate" name="empBean" />"/>
								</td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<input type="hidden" name="hidden" value="<jsp:getProperty property="employeeCode" name="empBean" />"/>
					<input type="submit" value="従業員情報更新">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="キャンセル">
								</form>
							</td>
						</tr>
					</table>

		<a href="menu.jsp">戻る</a>
						<!-- ※編集項目<br> <input type="submit" value="従業員情報編集">
						ToDo 可能ならばキャンセル可能にしてください -->
		<%@ include file="footer.jsp"%></body>
</html>