<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>UserList</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<div class="container">
		<br> <br>
		<h1 class="text-center">ユーザー一覧</h1>
		<br>
		<form action="UserListServlet" method="post">
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-6">
						<label for="formGroupExampleInput">ログインID</label> <input
							type="text" class="form-control" name="login_id" id="login_id"
							placeholder="loginID">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-6">
						<label for="name">ユーザー名</label> <input type="text"
							class="form-control" id="name" name="name" placeholder="username">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-6">
						<label for="bad">通報数</label> <input type="text"
							class="form-control" name="bad" id="bad">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="text-center">
				<button type="submit">検索</button>
			</div>
		</form>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">ログインID</th>
					<th scope="col">ユーザー名</th>
					<th scope="col">通報数</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userlist}">
					<tr>
						<th scope="row">${user.login_id}</th>
						<td>${user.name}</td>
						<td>${user.bad}</td>
						<td><a class="btn btn-outline-info"
							href="UserpageServlet?id=${user.id}" role="button">詳細</a> <a
							class="btn btn-outline-danger"
							href="UserDeleteServlet?id=${user.id}" role="button">削除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>