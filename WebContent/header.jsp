<%@ page pageEncoding="UTF-8"%>
<%
	String userid = (String)session.getAttribute("userid");
%>

ログインユーザ：<%=userid %>