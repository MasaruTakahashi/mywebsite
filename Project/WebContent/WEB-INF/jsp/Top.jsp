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
<title>Top</title>

</head>
<body>

	<%
		boolean isLogin = session.getAttribute("isLogin") != null ? (boolean) session.getAttribute("isLogin")
				: false;
	%>
	<%
		if (isLogin) {
	%>
	<jsp:include page="/WEB-INF/jsp/Header2.jsp" />
	<%
		} else {
	%>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<%
		}
	%>

	<br>
	<br>
	<div class="container">
		<div class="card-deck">
			<a
				href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/mywenbsite/Mock/Item.html"
				class="card"> <img class="card-img-top" src=".../100px200/"
				alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">商品名</h5>
					<p class="card-text">¥〇〇〇</p>
				</div>
			</a> <a
				href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/mywenbsite/Mock/Item.html"
				class="card"> <img class="card-img-top" src=".../100px200/"
				alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">商品名</h5>
					<p class="card-text">¥〇〇〇</p>
				</div>
			</a> <a
				href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/mywenbsite/Mock/Item.html"
				class="card"> <img class="card-img-top" src=".../100px200/"
				alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">商品名</h5>
					<p class="card-text">¥〇〇〇</p>
				</div>
			</a>
		</div>
	</div>
</body>
</html>