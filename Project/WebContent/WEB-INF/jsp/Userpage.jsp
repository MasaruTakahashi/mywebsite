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
	<link rel="stylesheet" href="css/css.css">
<title>Userpage</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<div class="container">
		<br> <br>
		<div class="text-right">
			<c:if test="${userinfo.id == 1}">
				<a class="btn btn-warning" href="UserListServlet" role="button">ユーザー一覧</a>
			</c:if>
			<c:if test="${userinfo.id == user.id}">
				<a class="btn btn-primary"
					href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/mywenbsite/Mock/Userupdate.html?"
					role="button">変更</a>
			</c:if>
		</div>
		<p class="text-center">${user.name}</p>

		<br>
		<c:if test="${userinfo.id == user.id}">
			<p class="text-center">保有ポイント</p>
			<c:if test="${user.point == null}">
				<p class="text-center">0 P</p>
			</c:if>
			<c:if test="${user.point != null}">
				<p class="text-center">${user.point}P</p>
			</c:if>
		</c:if>
		<br>
		<p class="text-center">住所</p>
		<p class="text-center">${user.address}</p>
		<br>
		<c:if test="${user.detail != null}">
			<p class="text-center">コメント</p>
			<p class="text-center">${user.detail}</p>
		</c:if>
		<br>
		<c:if test="${userinfo.id == user.id}">
			<div class="row">
				<div class="col"></div>
				<div class="col-5 text-center">
					<a class="btn btn-outline-danger btn-block btn-lg"
						href="ItemRegistrationServlet?id=${userinfo.id}" role="button">出品する</a>
				</div>
				<div class="col"></div>
			</div>
		</c:if>
		<br> <br>

		<div class="card-deck">
			<c:forEach var="item" items="${itemlist}">
			<div class="cardsize">
			<a href="ItemServlet?id=${item.id}">
				<div class="card">
					<img class="card-img-top" src="${item.photo}">
					<div class="card-body">
							<h5 class="card-title">${item.name}</h5>
							<p class="card-text">¥${item.price}</p>
					</div>
				</div>
			</a>
			</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>