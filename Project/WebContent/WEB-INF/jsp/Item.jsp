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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/css.css">
<title>Item</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<br>
	<br>
	<div class="container">
		<c:if test="${userinfo.id == item.user_id || userinfo.id == 1}">
			<div class="text-right">
				<a class="btn btn-primary" href="ItemupdateServlet?id=${item.id }"
					role="button">変更</a>
			</div>
		</c:if>

		<h2 class="text-center">${item.name}</h2>
		<br> <br>
		<div class="row">
			<div class="col">
				<img src="${item.photo }" alt="${item.photo }" class="img-thumbnail">
			</div>
			<div class="col">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th>出品者</th>
							<td><a href="UserpageServlet?id=${item.user_id }">${item.userName}</a></td>
						</tr>
						<tr>
							<th>商品の状態</th>
							<td>${item.item_stateDetail}</td>
						</tr>
						<tr>
							<th>配送料の負担</th>
							<td>${item.deliveryDetail}</td>
						</tr>
						<tr>
							<th>発送元</th>
							<td>${item.userAddress}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<h1 class="text-center">¥${item.price }</h1>
		<c:if test="${item.item_num == 1}">
			<form action="BuyServlet" method="post">
				<input type="hidden" name="item_id" value="${item.id}"> <input
					type="hidden" name="user_id" value="${userinfo.id}">
				<button class="btn btn-danger btn-block btn-lg" type="submit"
					role="button">購入画面に進む</button>
			</form>
		</c:if>
		<c:if test="${item.item_num == 2}">
			<button class="btn btn-danger btn-block btn-lg" role="button">売り切れ</button>
		</c:if>

		<br>
		<p class="text-center">${item.detail }</p>
		<c:if test="${item.user_id != userinfo.id}">
			<form action="GoodServlet" method="post">
				<input type="hidden" name="user_id" value="${userinfo.id }">
				<input type="hidden" name="item_id" value="${item.id}">
				<button class="btn btn-outline-danger btn-sm" type="submit"
					role="button">
					<i class="far fa-heart"></i>${good.count}</button>
			</form>
		</c:if>
		<c:if test="${item.user_id == userinfo.id}">
			<button class="btn btn-outline-danger btn-sm" type="button" disabled>
				<i class="far fa-heart"></i>${good.count}</button>
		</c:if>
		<c:if test="${item.user_id != userinfo.id}">
			<form action="BadServlet" method="post">
				<input type="hidden" name="id" value="${item.user_id }"> <input
					type="hidden" name="item_id" value="${item.id }">
				<button class="btn btn-outline-info btn-sm" type="submit"
					role="button">通報する</button>
			</form>
		</c:if>
		<c:if test="${item.user_id == userinfo.id}">
			<button class="btn btn-outline-info btn-sm" role="button"
				type="submit" disabled>通報する</button>
		</c:if>
		<br> <br>
		<c:if test="${isEmpty != null}">
			<table class="table">
				<thead>
					<tr>
						<th scope="col" class="text-center">${isEmpty}</th>
					</tr>
				</thead>
			</table>
		</c:if>
		<c:if test="${isEmpty == null}">
			<div class="scroll">
				<table class="table">
					<thead>
					<tbody>
						<c:forEach var="comment" items="${commentlist}">
							<tr>
								<th scope="row">${comment.userName }</th>
								<td class="text-center">${comment.detail }</td>
								<td class="text-right">${comment.create_date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		<br>
		<form action="CommentServlet" method="post">
			<input type="hidden" name="item_id" value="${item.id }"> <input
				type="hidden" name="user_id" value="${userinfo.id }"> <label
				for="comment">コメント</label>
			<textarea class="form-control" id="comment" name="detail" rows="3"></textarea>
			<br>
			<button type="submit" class="btn-block">コメントする</button>
		</form>
		<br>
		<c:if test="${userinfo.id == item.user_id || userinfo.id == 1}">
			<div class="text-right">
				<a href="ItemDeleteServlet?id=${item.id}"> 商品を削除 </a>
			</div>
		</c:if>
		<br> <br>
	</div>
</body>
</html>