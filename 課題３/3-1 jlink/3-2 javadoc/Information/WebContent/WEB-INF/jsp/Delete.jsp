<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.InfoBeans,java.util.List"%>
<%
	List<InfoBeans> list = (List<InfoBeans>) request.getAttribute("list");
request.setAttribute("data", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了画面</title>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<h1>削除処理を完了しました！</h1>
	<jsp:include page="./Whole.jsp" />
</body>
</html>