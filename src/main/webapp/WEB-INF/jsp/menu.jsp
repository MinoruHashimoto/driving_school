<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//リクエストスコープからインスタンスを取得
String loginNG = (String) request.getAttribute("loginNG");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/color.css">
<title>教習所システム</title>
</head>
<body>
	<h1>教習所システム</h1><br>
	<h2>メニュー</h2>


	<form action="/driving_school/StudentServlet"  method="get">
			<div class="button_wrapper">
			<button type="submit" id="gradual">生徒名簿入力画面</button>
		</div>
	</form><br>
	
	<!-- <button type="button" onclick="location.href='/WEB-INF/jsp/menu.jsp'">生徒名簿入力画面</button> -->

	<form action="/driving_school/LoginServlet"  method="get">
			<div class="button_wrapper">
			<button type="submit" id="gradual">終了</button>
		</div>
	</form>

</body>
</html>