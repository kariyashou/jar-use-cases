<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--画面に表を表示して最後の要素の後に機能ボタンを実装しIDを選択させなくする --%>
<%@ page import="dao.SelectDAO,model.InfoBeans,java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	SelectDAO select = new SelectDAO();
List<InfoBeans> list = select.sort();
request.setAttribute("data", list);
int count = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./index.css?20200902" rel="stylesheet">
<link href="./Whole.css?20200902" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<form action="SelectServlet" method="post">
		<table>
			<tr>
				<td><input type="submit" name="button" value="追加する"
					class="button"><br></td>
				<td><input type="submit" name="button" value="検索する"
					class="button"><br></td>
			</tr>
		</table>
	</form>
	<div class="data">
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
				<th class="item">機能:変更</th>
				<th class="item">機能:削除</th>
			</tr>
		</table>
		<c:forEach var="obj" items="${data}" varStatus="status">
			<form action="SelectServlet" method="post">
				<table>
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
						<td><button type="submit" name="button" value="変更する">変更する</button>
							<br></td>
						<td><button type="submit" name="button" value="削除する">削除する</button>
							<br></td>
						<td><input type="hidden" name="id" value="${obj.id}"></td>
					</tr>
				</table>
			</form>
		</c:forEach>
	</div>
</body>
</html>
