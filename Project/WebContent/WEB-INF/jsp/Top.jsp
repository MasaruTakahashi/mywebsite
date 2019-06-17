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
<title>Top</title>

</head>
<body>


	<jsp:include page="/WEB-INF/jsp/Header.jsp" />

	<br>
	<br>
	<div class="container">
		<div class="row">
			<c:forEach var="item" items="${itemlist}">
				<div class="col-4">

					<a href="ItemServlet?id=${item.id }" class="card"> <img
						class="card-img-top imgSize" src="${item.photo }"
						alt="${item.photo }">
						<div class="card-body">
							<h5 class="card-title">${item.name }</h5>
							<p class="card-text">¥${item.price }</p>
						</div>
					</a>

				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>