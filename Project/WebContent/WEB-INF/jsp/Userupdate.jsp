<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Userupdate</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<br>
	<br>
	<div class="container">
		<form action="UserupdateServlet" method="post">
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
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<label for="passwordCon">パスワード(確認)</label> <input type="password"
							class="form-control" id="passwordCon" name="passwordCon" placeholder="Password">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<label for="name">ユーザー名</label> <input type="text"
							class="form-control" id="name" name="name" placeholder="UserName">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<label for="address">住所</label> <input type="text"
							class="form-control" id="address" name="address" placeholder="address">
					</div>
					<div class="col"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<label for="comment">コメント</label>
						<textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
					</div>
					<div class="col"></div>
				</div>
			</div>

			<div class="row text-center">
				<div class="col"></div>
				<div class="col-5">
					<button type="submit" class="btn btn-primary btn-block">変更</button>
				</div>
				<div class="col"></div>
			</div>
			<br>

		</form>

		<br>

	</div>

</body>
</html>