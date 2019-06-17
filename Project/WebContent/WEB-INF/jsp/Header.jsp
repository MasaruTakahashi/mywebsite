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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<link rel="stylesheet" href="css.css">
<title>Header</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="TopServlet" class="col-2  header-font"> <i
				class="fas fa-cube"></i>フリマ
			</a>
			<div class="col-10 text-right">
				<form action="SearchServlet" method="post">
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="searchword"
							aria-describedby="button-addon2">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary form-control"
								type="submit" id="button-addon2">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<%
			boolean isLogin = session.getAttribute("isLogin") != null ? (boolean) session.getAttribute("isLogin")
					: false;
		%>
		<%
			if (isLogin) {
		%>
		<div class="row">
			<div class="col-8"></div>
			<div class="col-4 text-right">
				<a class="btn btn-outline-danger"
					href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/mywenbsite/Mock/GoodList.html"
					role="button">いいね<i class="far fa-heart"></i></a> <a
					class="btn btn-outline-warning"
					href="UserpageServlet?id=${userinfo.id}" role="button">マイページ</a> <a
					class="btn btn-outline-info" href="LogoutServlet" role="button">ログアウト</a>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="row">
			<div class="col-9"></div>
			<div class="col-3 text-right">
				<a class="btn btn-outline-danger" href="LoginServlet" role="button">ログイン</a>
				<a class="btn btn-outline-info" href="UserRegistrationServlet"
					role="button">新規登録</a>
			</div>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>