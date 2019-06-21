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
<title>login</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">
			<a href="TopServlet">
			<i class="fas fa-cube"></i>フリマ
			</a>
		</h1>
		<br> <br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center" scope="col"><h3>ログイン</h3></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"><br>
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<div class="row">
									<div class="col"></div>
									<div class="col-10">
										<label for="login_id">ログインID</label> <input type="text"
											class="form-control" id="login_id" name="login_id" placeholder="LoginID">
									</div>
									<div class="col"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col"></div>
									<div class="col-10">
										<label for="password">パスワード</label> <input type="password"
											class="form-control" id="password" name="password" placeholder="Password">
									</div>
									<div class="col"></div>
								</div>
							</div>

							<div class="row text-center">
								<div class="col"></div>
								<div class="col-5">
									<button type="submit" class="btn btn-danger btn-block">ログイン</button>
								</div>
								<div class="col"></div>
							</div>
							<br>

						</form></th>
				</tr>
				<tr>
					<th scope="row">
						<div class="text-center">
							<br>初めての利用の方はこちら！！<br> <br>
						</div>
						<div class="row text-center">
							<div class="col"></div>
							<div class="col-5">
								<a class="btn btn-primary btn-block"
									href="UserRegistrationServlet"
									role="button">新規登録</a>
							</div>
							<div class="col"></div>
						</div> <br>
					</th>

				</tr>

			</tbody>
		</table>
	</div>
</body>
</html>