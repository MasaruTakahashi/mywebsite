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
<title>Buy</title>
</head>
<body>
<jsp:include page="/mywenbsite_Mock/Header.jsp" />ヘッダーが入る
	<br>
	<br>
	<div class="container">
		<br> <br>
		<h2 class="text-center">購入確認</h2>
		<br>
		<br>
		<p class="text-center">商品名</p>
		<p class="text-center">¥〇〇〇</p>
		<p class="text-center">送料の有無</p>
		<p class="text-center">所有ポイント</p>

		<div class="row">
			<div class="col"></div>
			<div class="col-5">
				<label for="exampleInputEmail1">ポイント</label> <input type="text"
					class="form-control" id="point" placeholder="使用ポイント数"> <br>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">ポイントを使う</button>
				</div>
			</div>
			<div class="col"></div>
		</div>

		<hr>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">商品代金</th>
					<th scope="col">使用ポイント数</th>
					<th scope="col">合計金額</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">¥〇〇〇</th>
					<td>〇〇〇</td>
					<td>¥〇〇〇</td>
				</tr>
			</tbody>
		</table>


		<div class="text-center">
			<button type="submit" class="btn btn-danger">購入確定</button>
		</div>
		<div class="col"></div>

	</div>
</body>
</html>