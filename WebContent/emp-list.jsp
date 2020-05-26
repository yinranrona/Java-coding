<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "model.entity.ListEmpBean" %>
<%@ page import = "model.entity.EmpBean" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報一覧</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<!-- ToDo 従業員情報を一覧表示してください -->
	<!-- ToDo 従業員を1名選択し、従業員情報編集画面に移行してください -->
	<!-- ToDo 以下はサンプルとして1名分だけ表示するようにします -->
<%! ListEmpBean leb; %>
<%! EmpBean eb; %>
<%! String employeeCode; %>
<%! String lastName; %>
<%! String firstName; %>
<%! String lastKanaName; %>
<%! String firstKanaName; %>
<%! int gender; %>
<%! Date birthDay; %>
<%! String sectionCode; %>
<%! Date hireDate; %>
<%! Date updateDatetime; %>
<%
	leb = (ListEmpBean)request.getAttribute("listEmp");
%>
<table>
    <caption>従業員情報一覧</caption>
    <tr><th>従業員コード</th><th>氏</th><th>名</th><th>氏かな</th><th>名かな</th><th>性別</th><th>生年月日</th><th>部署コード</th><th>入社日</th><th>更新日時</th></tr>
<%
	eb = leb.getEmpBean(0);
%>
 <tr>
 	<th>
	<%=eb.getEmployeeCode()%>
    </th><th>
	<%=eb.getLastName()%>
	</th><th>
	<%=eb.getFirstName()%>
	</th><th>
	<%=eb.getLastKanaName()%>
	</th><th>
	<%=eb.getFirstKanaName()%>
	</th><th>
	<%=eb.getGender()%>
	</th><th>
	<%=eb.getBirthDay()%>
	</th><th>
	<%=eb.getSectionCode()%>
	</th><th>
	<%=eb.getHireDate()%>
	</th><th>
	<%=eb.getUpdateDatetime()%>
	</th><th>
	<form action="emp-update-servlet" method="POST">
		<input type="submit" value="編集">
	</form>
	</th>
</tr>
</table>

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面">
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>