<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>
	
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:useBean id="date" class="java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報登録</title>
<link rel="stylesheet" type="text/css" href="css/emp-input.css"/>
</head>
<body>
<div class="div1">
	<%@ include file="header.jsp" %>
	<h3>従業員情報登録</h3>
	<form action="emp-input-result-servlet" method="POST"><br>
	
	<!-- ToDo formにデータを設定します -->
	<table style="margin: 0 auto">
		<tr>
		<td style="text-align:right; width:20%">従業員コード：</td>
		<td style="width:20%"><input type="text" name="empcode" value="${empcode}"/></td>
			<c:if test="${empcodenull.equals(\"empcodenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
			<c:if test="${modeForward == 2}">
				<td><font color="red">従業員コードの形式エラー</font></td>
			</c:if>
			<c:if test="${modeForward == 6}">
				<td><font color="red">認証エラー：従業員コードが存在しました。</font></td>
			</c:if>
		<td><font color="#999999">Eから始める数字 例：E0001~E9999</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">氏：</td>
		<td style="width:20%"><input type="text" name="lastname" value="${lastname}"/></td>
		 	<c:if test="${lastnamenull.equals(\"lastnamenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
		<td><font color="#999999">漢字、アルファベットで入力してください</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">名：</td>
		<td style="width:20%"><input type="text" name="firstname" value="${firstname}"/></td>
			<c:if test="${firstnamenull.equals(\"firstnamenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
		<td><font color="#999999">漢字、アルファベットで入力してください</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">氏かな：</td>
		<td style="width:20%"><input type="text" name="lastkananame" value="${lastkananame}"/></td>
			<c:if test="${lastkananamenull.equals(\"lastkananamenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
			<c:if test="${modeForward == 401}">
				<td><font color="red">全角かなエラー</font></td>
			</c:if>
		<td><font color="#999999">全角仮名で入力してください</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">名かな：</td>
		<td style="width:20%"><input type="text" name="firstkananame" value="${firstkananame}"/></td>
			<c:if test="${firstkananamenull.equals(\"firstkananamenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
			<c:if test="${modeForward == 402}">
				<td><font color="red">全角かなエラー</font></td>
			</c:if>
		<td><font color="#999999">全角仮名で入力してください</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">性別：</td>
		<td style="width:20%">
			<input type="radio" name="gender" value="1" <c:if test="${gender.equals(\"1\")}">checked="checked"</c:if>/>男
			<input type="radio" name="gender" value="2" <c:if test="${gender.equals(\"2\")}">checked="checked"</c:if>/>女
			<input type="radio" name="gender" value="0" <c:if test="${gender.equals(\"0\")}">checked="checked"</c:if>/>不明
		</td>
			<c:if test="${gendernull.equals(\"gendernull\")}">
				<td><font color="red">未選択</font></td>
			</c:if>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">生年月日：</td>
		<td style="width:20%">
			<select name="year">
				<option value=<c:out value="${year}"/>><c:out value="${year}"/></option>
				<c:forEach begin="1920" end="2020" step="1" varStatus="status">
				<option value=<c:out value="${status.index}"/>><c:out value="${status.index}"/>
				</option>
				</c:forEach>
			</select>
				<c:if test="${yearnull.equals(\"yearnull\")}">
					<font color="red">年</font>
				</c:if>
			<select name="month">
				<option value=<c:out value="${month}"/>><c:out value="${month}"/></option>
				<c:forEach begin="1" end="12" step="1" varStatus="status">
				<option value=<c:out value="${status.index}"/>><c:out value="${status.index}"/>
				</option>
				</c:forEach>
			</select>
				<c:if test="${monthnull.equals(\"monthnull\")}">
					<font color="red">月</font>
				</c:if>
			<select name="day">
				<option value=<c:out value="${day}"/>><c:out value="${day}"/></option>
				<c:forEach begin="1" end="31" step="1" varStatus="status">
				<option value=<c:out value="${status.index}"/>><c:out value="${status.index}"/>
				</option>
				</c:forEach>
			</select>
				<c:if test="${daynull.equals(\"daynull\")}">
					<font color="red">日</font>
				</c:if>
		</td>
			<c:if test="${daynull.equals(\"daynull\") || monthnull.equals(\"monthnull\") || yearnull.equals(\"yearnull\")}">
					<td><font color="red">未選択</font></td>
			</c:if>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">部署コード：</td>
		<td style="width:20%"><input type="text" name="sectioncode" value="${sectioncode}"/></td>
			<c:if test="${sectioncodenull.equals(\"sectioncodenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
			<%-- <c:if test="${modeForward == 3}">
				<td><font color="red">部署コードの形式エラー</font></td>
			</c:if> --%>
			<c:if test="${modeForward == 7}">
				<td><font color="red">部署コードが存在しません</font></td>
			</c:if>
		<td><font color="#999999">Sから始める数字</font></td>
		</tr>
		<tr>
		<td style="text-align:right; width:20%">入社日：</td>
		<td style="width:20%"><input type="text" name="hiredate" value="${hiredate}"/></td>
			<c:if test="${hiredatenull.equals(\"hiredatenull\")}">
				<td><font color="red">未入力</font></td>
			</c:if>
			<c:if test="${modeForward == 5}">
				<td><font color="red">入社日の形式エラー</font></td>
			</c:if>
		<td><font color="#999999">入力形式：YYYY-MM-DD</font></td>
		</tr>
	</table>
	
		<input type="submit" value="従業員情報登録">
	<!-- ToDo 可能ならばキャンセル可能にしてください -->
		<input type="reset" value="キャンセル"/>
	</form>
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>