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
<title>Buy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<br>
	<br>
	<div class="container">
		<br> <br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
		<h2 class="text-center">購入確認</h2>
		<br> <br>
		<p class="text-center">${item.name}</p>
		<p class="text-center">¥${item.price}</p>
		<p class="text-center">${item.deliveryDetail}</p>
		<p class="text-center">所有ポイント</p>
		<p class="text-center">${user.point}</p>

		<form action="UsepointServlet" method="post">
			<input type="hidden" name="item_id" value="${item.id}"> <input
				type="hidden" name="user_id" value="${user.id}">
			<div class="row">
				<div class="col"></div>
				<div class="col-5">
					<label for="exampleInputEmail1">ポイント</label> <input type="text"
						class="form-control" id="point" name="usepoint"
						placeholder="使用ポイント数"> <br>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">ポイントを使う</button>
					</div>
				</div>
				<div class="col"></div>
			</div>
		</form>
		<hr>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">商品価格</th>
					<th scope="col">使用ポイント</th>
					<th scope="col">合計金額</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">&yen;${item.price}</th>
					<td>${user.usepoint}</td>
					<td>&yen;${user.totalprice}</td>
				</tr>
			</tbody>
		</table>

		<form action="BuyConfirmServlet" method="post">
		<input type="hidden" name="point" value="${user.point}">
		<input type="hidden" name="usepoint" value="${user.usepoint}">
		<input type="hidden" name="SellUser_id" value="${item.user_id}">
		<input type="hidden" name="BuyUser_id" value="${userinfo.id}">
		<input type="hidden" name="item_num" value="2">
		<input type="hidden" name="item_id" value="${item.id}">
		<input type="hidden" name="price" value="${item.price}">
			<div class="text-center">
				<button type="submit" class="btn btn-danger">購入確定</button>
			</div>
			<div class="col"></div>
		</form>
	</div>
</body>
</html>