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
<title>UserDelete</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<br>
	<br>
	<div class="container">
		<h1 class="text-center">ユーザー削除</h1>
		<p class="text-center">${user.name}</p>
		<form action="UserDeleteServlet" method="post">
			<div class="row">
				<div class="col"></div>
				<div class="col-4">
					<input type="hidden" name="id" value="${user.id}">
					<button type="submit" class="btn btn-outline-danger btn-block"
						role="button">削除</button>
				</div>
				<div class="col"></div>
			</div>
		</form>
	</div>

</body>
</html>