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
<title>GoodList</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<br>
	<br>
	<div class="container">
		<div class="container">
			<c:if test="${goodlist != null}">
				<div class="row">
					<c:forEach var="good" items="${goodlist}">
						<div class="col-4">

							<a href="ItemServlet?id=${good.item_id }" class="card"> <img
								class="card-img-top imgSize" src="${good.itemPhoto }"
								alt="${item.photo }">
								<div class="card-body">
									<h5 class="card-title">${good.itemName }</h5>
									<p class="card-text">¥${good.itemPrice }</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${empty goodlist}">
			<h2 class= "text-center">いいね！した商品はありません。</h2>
			</c:if>
		</div>
	</div>
</body>
</html>