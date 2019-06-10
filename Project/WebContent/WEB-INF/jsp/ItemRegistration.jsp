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
<title>ItemRegistration</title>
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

<form action="ItemRegistrationServlet" method="post">
		<div class="form-group">
			<label for="itemphoto">画像</label> <input type="file"
				class="form-control-file" name="photo" id="itemphoto">
		</div>
		<div class="form-group row">
			<input type="hidden" name="user_id" value="${userinfo.id}">
		</div>
		<div class="form-group row">
			<input type="hidden" name="quantity" value="1">
		</div>
		<div class="form-group row">
			<label for="itemname" class="col-sm-2 col-form-label">商品名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="name" id="itemname">
			</div>
		</div>
		<div class="form-group row">
			<label for="price" class="col-sm-2 col-form-label">値段</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="price" id="price">
			</div>
		</div>
		<fieldset class="form-group">
			<div class="row">
				<legend class="col-form-label col-sm-2 pt-0">商品の状態</legend>
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="itemState"
							id="itemState1" value="1"> <label
							class="form-check-label" for="itemState1"> 新品 </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="itemState"
							id="itemState2" value="2"> <label
							class="form-check-label" for="itemState2"> 未使用に近い </label>
					</div>
					<div class="form-check disabled">
						<input class="form-check-input" type="radio" name="itemState"
							id="itemState3" value="3"> <label
							class="form-check-label" for="itemState3"> 傷や汚れあり </label>
					</div>
					<div class="form-check disabled">
						<input class="form-check-input" type="radio" name="itemState"
							id="itemState4" value="4"> <label
							class="form-check-label" for="itemState4"> 状態が悪い </label>
					</div>
				</div>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<div class="row">
				<legend class="col-form-label col-sm-2 pt-0">送料</legend>
				<div class="col-sm-10">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="delivery"
							id="delivery1" value="1"> <label class="form-check-label"
							for="delivery1"> 送料込み </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="delivery"
							id="delivery2" value="2"> <label class="form-check-label"
							for="delivery2"> 着払い </label>
					</div>
				</div>
			</div>
		</fieldset>
		<div class="form-group row">
			<label for="itemDetails" class="col-sm-2 col-form-label">商品詳細</label>
			<div class="col-sm-10">
				<textarea class="form-control" name="itemDetail" id="itemDetail" rows="3"></textarea>
			</div>
		</div>

		<div class="form-group row">
			<div class="col">
				<button type="submit" class="btn btn-primary btn-block">出品</button>
			</div>
		</div>
		</form>
	</div>
</body>
</html>