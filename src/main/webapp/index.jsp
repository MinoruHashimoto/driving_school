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
	<h1>教習所システム</h1>
	<!-- ログイン失敗のエラーメッセージを表示-->
	<%
	if (loginNG != null) {
	%>
	<p><%=loginNG%></p>
	<%
	}
	%>
	<form action="/driving_school/LoginServlet" method="post">
		<table class="form_table">
		<tr><td><input class="form" type="text" placeholder="ID" name="id" maxlength="8" required></td></tr>
		<tr><td>
		<input class="form" type="password" placeholder="パスワード" name="password" maxlength="16" required></td></tr>
		<tr><th></th></tr>
		</table>
		<pre>
		</pre>
		
		<div class="button_wrapper">
			<button type="submit" id="gradual">ログイン</button>
		</div>
	</form>
	<br>

	<form>
		<input type="button" name="button" value="このウィンドウを閉じる"
			onclick="window.close();">
	</form>
<script>

</script>
</body>
</html>