<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.InfoBeans,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% List<InfoBeans>list = (List<InfoBeans>)request.getAttribute("Info"); 
   request.setAttribute("Info",list);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./Whole.css?20200902" rel="stylesheet">
<title>検索結果画面</title>
</head>
<body>
	<jsp:include page="./Header.jsp" />
	<h1>検索処理を完了しました！</h1>
	<table>
		<tr>
			<th class="item">ID</th>
			<th class="item">氏名</th>
			<th class="item">カナ</th>
			<th class="item">メール</th>
			<th class="item">性別</th>
			<th class="item">誕生日</th>
			<th class="item">婚約</th>
			<th class="item">都道府県</th>
			<th class="item">電話</th>
			<th class="item">携帯</th>
			<th class="item">キャリア</th>
			<th class="item">カレーの食べ方</th>
		</tr>
		<c:forEach var="obj" items="${Info}" varStatus="status">
			<tr>
				<td class="element"><c:out value="${obj.id}" /></td>
				<td class="element"><c:out value="${obj.name}" /></td>
				<td class="element"><c:out value="${obj.kanaName}" /></td>
				<td class="element"><c:out value="${obj.email}" /></td>
				<td class="element"><c:out value="${obj.sexId}" /></td>
				<td class="element"><c:out value="${obj.birthday}" /></td>
				<td class="element"><c:out value="${obj.marriageId}" /></td>
				<td class="element"><c:out value="${obj.prefId}" /></td>
				<td class="element"><c:out value="${obj.tell}" /></td>
				<td class="element"><c:out value="${obj.phone}" /></td>
				<td class="element"><c:out value="${obj.careerId}" /></td>
				<td class="element"><c:out value="${obj.curry}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>