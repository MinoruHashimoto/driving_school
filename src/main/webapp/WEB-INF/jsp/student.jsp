<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%
//リクエストスコープからインスタンスを取得
String request_course = (String) request.getAttribute("request_course");
int glasses = 0;
if (request.getAttribute("glasses") != null) {
	glasses = (int) request.getAttribute("glasses");
}
Date starting_date = (Date) request.getAttribute("starting_date");
Date reception_date = (Date) request.getAttribute("reception_date");
String reception_employee = (String) request.getAttribute("reception_employee");
String reception_name = (String) request.getAttribute("reception_name");
String note = (String) request.getAttribute("note");
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
	<br>
	<h2>生徒入力名簿</h2>

	<form action="/StudentServlet/StudentServlet" method="post"
		　onSubmit="return check()">
		<div class="cp_ipselect">
			<select name="request_course" class="cp_sl06" required>
				<option value="" hidden disabled selected></option>
				<option value="01" <%if ("01".equals(request_course)) {%> selected
					<%}%>>普通車MT 原付・二輪免許無し</option>
				<option value="02" <%if ("02".equals(request_course)) {%> selected
					<%}%>>普通車MT 原付・二輪免許有り</option>
				<option value="03" <%if ("03".equals(request_course)) {%> selected
					<%}%>>普通車AT 原付・二輪免許無し</option>
				<option value="04" <%if ("04".equals(request_course)) {%> selected
					<%}%>>普通車AT 原付・二輪免許有り</option>
				<option value="05" <%if ("05".equals(request_course)) {%> selected
					<%}%>>普通車MT 仮免許有り</option>
				<option value="06" <%if ("06".equals(request_course)) {%> selected
					<%}%>>普通車AT 仮免許有り</option>
				<option value="07" <%if ("07".equals(request_course)) {%> selected
					<%}%>>普通車MT AT限定免許有り</option>
			</select> <span class="cp_sl06_highlight"></span> <span
				class="cp_sl06_selectbar"></span> <label class="cp_sl06_selectlabel">希望コース</label>
		</div>
		<p>
			眼鏡<br> <input type="radio" name="glasses" value=1
				<%if (1 == glasses) {%> checked <%}%> required> 有り <input
				type="radio" name="glasses" value=2 <%if (2 == glasses) {%> checked
				<%}%>> 無し
		</p>
		<table class="form_table">
			<tr>
				<td><input class="form" type="date" name="starting_date"
					placeholder="開始日" <%if (starting_date != null) {%>
					value=<%=starting_date%> <%}%> required pattern="^[0-9]+$"
					title="半角数字"></td>
			</tr>
			<tr>
				<td><input class="form" type="date" name="reception_date"
					placeholder="受付日" <%if (starting_date != null) {%>
					value=<%=reception_date%> <%}%> required pattern="^[0-9]+$"
					title="半角数字"></td>
			</tr>
			<tr>
				<td><input class="form" type="text" placeholder="受付担当者ID"
					name="reception_employee" maxlength="8"
					required　 pattern="^[0-9]+$" title="半角数字"></td>
			</tr>
			<tr>
				<td>受付担当者名称：</td>
			</tr>
			<tr>
				<th></th>
			</tr>
		</table>
		<pre>
		</pre>

		<div class="button_wrapper">
			<button type="submit" id="gradual"
				onclick="/driving_school/StudentServlet">問合せ</button>
		</div>
		<span class="button_wrapper">
			<button type="submit" id="gradual"
				onclick="/driving_school/RegisterServlet">登録</button>
		</span>
		<span class="button_wrapper">
			<button type="submit" id="gradual"
				onclick="/driving_school/ModifyServlet">修正</button>
		</span>
		<span class="button_wrapper">
			<button type="submit" id="gradual"
				onclick="/driving_school/DeleteServlet">削除</button>
		</span>
	</form>
	<br>

	<div class="button_wrapper">
		<button type="button" id="gradual" onclick="history.back()">終了</button>
	</div>

	<script>
	
	//buttonタグごとに送信先のコントローラを指定するための関数
    function submitForm(action)
    {
        document.getElementById('columnarForm').action = action;
        document.getElementById('columnarForm').submit();
    }
	</script>
</body>
</html>